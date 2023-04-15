package GUI;
import org.example.*;
import threads.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewFrame extends JFrame {

    private static JPanel panel = new JPanel();
    private static JScrollPane scrollPanel = new JScrollPane();
    private static JTextArea area= new JTextArea();

    public NewFrame(){

    setTitle("SIMULATION");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500, 500);

    add(panel);
     panel.setLayout(new GridLayout(0,1,0,0));

     Container container = new Container();
     container.setLayout(new BorderLayout());
     container.add(panel, BorderLayout.CENTER);

     scrollPanel = new JScrollPane(container);
     getContentPane().add(scrollPanel);

   // panel.add(area);

        Manager m=new Manager();

        startTimeThread();
        setVisible(true);

    }

    public void startTimeThread(){

        Threads t1= new Threads(MainFrame.getSimTime());
        t1.start();
    }

    public static void displayTime(String string){
        JTextArea area1= new JTextArea();
        panel.add(area1);
        String s=string+"\n"+"Waiting list: "+Manager.printList()+"\n\n";

        s+=Manager.print();

        area1.setText(s);
        area1.setEditable(false);
    }
}
