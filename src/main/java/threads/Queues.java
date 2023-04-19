package threads;

import GUI.NewFrame;
import org.example.*;
import threads.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Queues extends Thread {
    private List<Client> clients1 = new ArrayList<>();
    private List<Client> clients = Collections.synchronizedList(clients1);

    private List<Client> q1 = new ArrayList<>();
    private List<Client> onQueue =  Collections.synchronizedList(q1);


    public Queues(){
        synchronized (clients) {
                clients = Manager.printList();
        }
    }

    //@Override
    public synchronized void run(int i, int time) {

        synchronized (clients) {

            for (Client c : this.clients) {

                if (c.getArrival() == time) {
                        synchronized (onQueue){
                    onQueue.add(c);
                    Manager.remove(c);
                    clients.remove(c);}
//
//                if (onQueue.contains(c) && c.getArrival() + c.getService() >= time) {
//                    onQueue.remove(c);
                    break;
                }

//                if (onQueue.contains(c) && c.getArrival() + c.getService() >= time) {
//                    onQueue.remove(c);
//                    Manager.remove(c);
//                    clients.remove(c);
//                    break;
//                }
            //
            }

        System.out.println(i);
        System.out.println(clients);
//        if(onQueue.isEmpty()){
//            NewFrame.display("Queue "+(i+1)+": closed");}
//        else  NewFrame.display("Queue "+(i+1)+": ");




        synchronized (onQueue) {

            for (Client client :onQueue){

            }

            if (onQueue.isEmpty()) {
                NewFrame.sisplay("Queue " + i + ": closed", onQueue);
            } else NewFrame.sisplay("Queue " + i + ": ", onQueue);
        }

//        try {
//            Thread.sleep(1000); // wait for 1 second
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        }
    }


        public int getSize(){
        int contor=0;
        for(Client x: onQueue) contor++;
         return contor ;
        }

    }
//}
