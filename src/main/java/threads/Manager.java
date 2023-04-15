package threads;
import GUI.*;
import org.example.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Manager {

    private static ArrayList<Client> waiting = new ArrayList<>();

    Set<Integer> usedId=new HashSet<>();

    public Manager() {
        for (int i = 1; i <= MainFrame.getN(); i++) {

//            Client c = new Client();
//            for (Client j : waiting){
//                if (j.getId() == c.getId())
//                    c = new Client();
//                }
//            waiting.add(c);
//            }

            Client c = new Client();
            while (usedId.contains(c.getId()))
                c = new Client();
            usedId.add(c.getId());
            waiting.add(c);
        }
        verif();
    }


    public void verif(){

    }
        public static ArrayList printList(){
             return waiting;
        }

        public static String print(){
           String string ="";
           for(int i=0;i<MainFrame.getQ();i++)
               string+="Queue "+i+":\n\n";
        return string;
        }
}
