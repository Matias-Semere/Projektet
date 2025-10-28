package view;

import javax.swing.*;
import java.awt.*;
import controller.*;

public class MainFrame extends JFrame {

    public MainFrame(StudentCon sc) {
        setTitle("Student View");
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new StudentView(sc));
    }

    public MainFrame(AdminCon ac) {
        setTitle("Admin View");
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new AdminView(ac));
    }
}
