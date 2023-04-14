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

    private JTextField text = new JTextField();
    private JPanel panel = new JPanel();

    public NewFrame(){
    setTitle("SIMULATION");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500, 500);

    add(panel);
    text.setText("simulare");
    //wait(1000);
    panel.add(text);

    }
}
