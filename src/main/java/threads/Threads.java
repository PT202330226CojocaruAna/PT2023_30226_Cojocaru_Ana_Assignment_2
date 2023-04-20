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
    //private static List<Queues> ordonat1 = new ArrayList<Queues>();
    private ArrayList<Queues> ordonat = new ArrayList<>();
  //  private Queues[] ordonat=null;
    int ok=0;
    int j = 1;

    @Override
    public void run() {
        //System.out.println("This thread is running");
        synchronized (fire) {
            int seconds = duration;
            while (seconds > 0) {

                if (seconds == duration) {

                    for (int i = 0; i < MainFrame.getQ(); i++) {
                        Queues t = new Queues();
                        fire.add(t);
                    }
                }
                NewFrame.displayTime("Time:" + (duration - seconds));

                List<Queues> copie = new ArrayList<Queues>();
                copie = fire;

                Collections.sort(copie, Comparator.comparingInt(Queues::getSize));

                ArrayList<Queues> ordonat = new ArrayList<>(copie);

           //     synchronized (fire) {
//                    for (int i = 0; i < MainFrame.getQ(); i++) {
//
//                        int min = MainFrame.getN();
//                        Queues qMin = null;
//
//
//                        Iterator<Queues> iterator = copie.iterator();
//
//                   //     while (iterator.hasNext()) {
//                            for(Queues s: fire) {
//                                // Queues s = iterator.next();
//                               // s.run2(j, duration, seconds);
//                                int ok=0;
//                                System.out.println(s.getSize());
//                                for (Queues ord:ordonat){if(ord==s) ok++; }
//                                    if ((s.getSize() < min) && ok==0) {
//                                        min = s.getSize();
//                                        qMin = s;
//                                    }
//                            }
//                        if (qMin != null)
//                            ordonat.add(qMin);
//                    }
//          //      }
                System.out.println(ordonat);
//
                for (int i = 0; i < ordonat.size(); i++) {
                    ordonat.get(i).run(i,duration,seconds);
                }

//                for(Queues queue:ordonat){
//                   int i=0;
//                    for(Queues fir: fire){
//                        if(fir==queue)
//                            queue.run();
//                        i++;
//                    }
//                }


                    BufferedWriter bw = null;
                    try {
                        String mycontent = "Time:" + (duration - seconds);
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
