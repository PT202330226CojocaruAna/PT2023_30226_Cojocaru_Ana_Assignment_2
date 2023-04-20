package threads;

import GUI.MainFrame;
import GUI.NewFrame;
import org.example.*;

import java.sql.Array;
import java.util.*;


public class Queues extends Thread{ // implements Comparable {
    private static List<Client> clients1 = new ArrayList<>();
    private static List<Client> clients = Collections.synchronizedList(clients1);

    private List<Client> q1 = new ArrayList<>();
    private List<Client> onQueue =  Collections.synchronizedList(q1);
    private int size = onQueue.size();
    int contor=0;


    public Queues(){
        synchronized (clients) {
                clients = Manager.printList();
        }
    }

    //@Override
    public synchronized void run(int i, int duration, int seconds) {
        int time = duration - seconds;
     //   clients=Manager.printList();

      //  synchronized (clients) {

//            Iterator<Client> iterator = clients.iterator();
//            while (iterator.hasNext()) {
//                Client c = iterator.next();
//                if (c.getArrival() == time) {
//                    synchronized (onQueue) {
//                        onQueue.add(c);
//                        Manager.remove(c);
//                      //  iterator.remove();
//                    }
//                }
//            }
//
        contor=0;
        for (Client c : clients) {
            if (c.getArrival() == time) contor++;
        }

        List<Client> clientsToAdd = new ArrayList<>();
                for (Client c : clients) {
                    if (c.getArrival() == time) {
                        if(clientsToAdd.size()>(contor/MainFrame.getQ())) {
                                //       Manager.remove(c);
                                //       clients.remove(c);
                            break;
                        }
                        else   clientsToAdd.add(c);
                }
            }

                synchronized (onQueue){
                    onQueue.addAll(clientsToAdd);
                    Manager.removeAll(clientsToAdd);
                    clients.removeAll(clientsToAdd);
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
                            c.decrementServiceTime();
                            if ((c.getService() == 0)){
                                onQueue.remove(c);
                                Manager.remove(c);
                                clients.remove(c);
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
   //     }
//decrementeazaaaaaaaaaa timpuuuuuuuu!

    public synchronized void run2(int i, int duration, int seconds) {
        int time = duration - seconds;

        synchronized (clients) {

            for (Client c : clients) {
                if (c.getArrival() == time) {
                    synchronized (onQueue) {
                        onQueue.add(c);
                    }
                    break;
                }
            }

            synchronized (onQueue) {

                if (onQueue.isEmpty()) {
                    contor=-1;
                } else {

                    //   List<Client> lista = onQueue;
                    for(Client c:onQueue){
                        if ((c.getService()==0)){
                            onQueue.remove(c);
                        }
                        break;
                    }
                    if(onQueue.isEmpty()) {contor=-1;}
                    else {
                        contor=0;
                        for(Client x: onQueue) contor++;
                    }
                }
            }

        }
    }
        public int getSize(){
          return onQueue.size();
        //return size;
        }



}
//}
