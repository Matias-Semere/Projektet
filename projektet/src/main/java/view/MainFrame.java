package view;

import javax.swing.*;
import java.awt.*;
import controller.*;

public class MainFrame extends JFrame {

    public MainFrame(StudentCon sc) {
        this();
        setTitle("Student View");
        add(new StudentView(sc));
    }

    public MainFrame(AdminCon ac) {
        this();
        setTitle("Admin View");
        add(new AdminView(ac));
    }

    public MainFrame(LärareCon lc) {
        this();
        setTitle("Student Database");
        add(new LärareView(lc));
    }

    public MainFrame() {
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
