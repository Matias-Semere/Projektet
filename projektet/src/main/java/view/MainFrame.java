package view;

import javax.swing.JFrame;

import controller.AdminCon;
import controller.StudentCon;

public class MainFrame extends JFrame {

    public MainFrame(StudentCon sc) {
        setTitle("Student Database");
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new StudentView(sc));
    }

    public MainFrame(AdminCon ac) {
        setTitle("Student Database");
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new AdminView(ac));
    }
}
