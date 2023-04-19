package threads;
import GUI.*;
import org.example.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Threads extends Thread{

  //  private ArrayList<Threads> fire = new ArrayList<>();
    private int duration;

    public Threads(int duration){
        this.duration = duration;
    }
    private static List<Queues> fir= new ArrayList<Queues>();
    private static List<Queues> fire = Collections.synchronizedList(fir);
    int ok=0;
    int j = 1;

    @Override
    public void run() {
        //System.out.println("This thread is running");
        synchronized(fire) {
            int seconds = duration;
            while (seconds > 0) {

                if (seconds == duration) {

                    for (int i = 0; i < MainFrame.getQ(); i++) {
                        Queues t = new Queues();
                        fire.add(t);
                    }

                }
                NewFrame.displayTime("Time:" + (duration - seconds));

//                for (int i = 0; i < MainFrame.getQ(); i++)
//                fire.get(i).run(i,duration-seconds+1);

//               int min = MainFrame.getN();
//               Queues qMin = null;

                j=0;
                for (Queues q: fire){
                    q.run(j,duration-seconds);
                    j++;
                }

//               // int j = 1;
//                j=1;
//                //  Queues q =fire.get(j);
//                for (Queues q : fire) {
//                 //  Queues q = fire.get(j);
//                    if (q.getSize() <= min) {
//                        min = q.getSize();
//                        qMin = q;
//                        qMin.run(j, duration - seconds + 1);
//                    } //else {
//                        q.run(j, duration - seconds + 1);
//                    }
//j++;
//
//                    j=1;
//                   q =fire.get(j);
//                    if(q==null)
//                    q.run(j, duration - seconds + 1);
//                    else qMin.run(j,duration-seconds +1);
//                    if(j<fire.size()){
//                    j++;}
               // }

                //   String s= Integer.toString(i);
                //   NewFrame.display(s);
                //  }

                BufferedWriter bw = null;
                try {
                    String mycontent = "Time:" + (duration - seconds);
                    //Specify the file name and path here
                    File file = new File("B:/no idea/intellij/projects/PT2023_30226_Cojocaru_Ana_2/filename.txt");

                    FileWriter fw = new FileWriter(file);
                    bw = new BufferedWriter(fw);
                    bw.write(mycontent);
                    System.out.println("File written Successfully");

                } catch (IOException ioe) {
                }

                try {
                    sleep(1000);
                } catch (InterruptedException intr) {
                }
                seconds--;

                if (seconds == 0) {
                    finish();
                }

                //   for (int i = 0; i < MainFrame.getQ(); i++) {

                //      fire.get(i).start();
                //   try{this.join();}//  catch(InterruptedException ie){}
                //   }
            }
        }
    }

    public int getDuration(){
      return duration;
    }

    public void finish(){
        NewFrame.displayService(Manager.getAverageService());
        System.out.println(Manager.getAverageService());
    }

}
