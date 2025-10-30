package view;

import java.awt.*;
import java.util.Map;

import javax.swing.*;

import controller.AdminCon;
import model.Betyg;
import model.Student;
import model.Betyg.Grades;

public class AdminView extends JPanel {

    private AdminCon ac;
    private JButton addButton;
    private String htmlstyle = "<html><style> h3 {color: White; border: 10px solid black; padding: 10px;}</style> <h3>";

    public AdminView(AdminCon adminCon) {
        this.ac = adminCon;
        setSize(500, 500);
        setBackground(Color.DARK_GRAY);

        

    }

    public void initComponents() {
        addButton = new JButton("Lägg till lärare");
        
    }

}
