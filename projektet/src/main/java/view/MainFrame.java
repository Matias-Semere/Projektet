package view;

import javax.swing.*;
import java.awt.*;
import controller.*;

public class MainFrame extends JFrame {

    public MainFrame(JPanel view, String title) {
        super(title);                 
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(view);                     
        setVisible(true);
    }

}
