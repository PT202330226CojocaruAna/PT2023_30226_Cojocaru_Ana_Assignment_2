package threads;

import GUI.NewFrame;
import org.example.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Queues extends Thread {
    private static List<Client> clients1 = new ArrayList<>();
    private static List<Client> clients = Collections.synchronizedList(clients1);

    private List<Client> q1 = new ArrayList<>();
    private List<Client> onQueue =  Collections.synchronizedList(q1);
    int contor;


    public Queues(){
        synchronized (clients) {
                clients = Manager.printList();
        }
    }

    //@Override
    public synchronized void run(int i, int duration, int seconds) {
        int time = duration - seconds;

        synchronized (clients) {

            for (Client c : clients) {
                if (c.getArrival() == time) {
                    synchronized (onQueue) {
                        onQueue.add(c);
                       // Manager.remove(c);
                        clients.remove(c);
                    }
                    break;
                }
            }

                System.out.println(i);
                System.out.println("timp "+time);
                System.out.println("duration "+duration);
                System.out.println("seconds "+seconds);
                System.out.println("clientii " + clients);
                System.out.println("coada " + onQueue);

                synchronized (onQueue) {

                    if (onQueue.isEmpty()) {
                        contor=-1;
                        NewFrame.sisplay("Queue " + (i + 1) + ": closed", onQueue);
                    } else {

                     //   List<Client> lista = onQueue;
                        for(Client c:onQueue){
                            if ((c.getService() +c.getArrival() == time)){
                                onQueue.remove(c);
                            }
                        break;
                        }
                        if(onQueue.isEmpty()) {contor=-1; NewFrame.sisplay("Queue " + (i + 1) + ": closed", onQueue);}
                        else {
                            contor=0;
                            for(Client x: onQueue) contor++;
                            //  System.out.println(contor);
                        NewFrame.sisplay("Queue " + (i + 1) + ": ", onQueue);
                        }
                    }
                }

            }
        }

        public int getSize(){
         return contor ;
        }

    }
//}
