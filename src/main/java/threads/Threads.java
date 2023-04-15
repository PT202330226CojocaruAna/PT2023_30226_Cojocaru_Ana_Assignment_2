package threads;
import GUI.*;
import org.example.*;

import java.util.ArrayList;

public class Threads extends Thread{

    private ArrayList<Threads> fire = new ArrayList<>();

    private int duration;

    public Threads(int duration){
        this.duration = duration;
    }

    public Threads(){}

    @Override
    public void run(){
        //System.out.println("This thread is running");
        int seconds= duration;
        while(seconds>0){
            NewFrame.displayTime("Time:"+(duration-seconds));
            try{
                sleep(1000);
            }catch(InterruptedException intr){}
        seconds--;
        }

        for (int i=0;i<MainFrame.getQ();i++)
        {
            Threads t=new Threads();
            fire.add(t);
        }
    }
}
