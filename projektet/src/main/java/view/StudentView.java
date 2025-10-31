package view;

import javax.swing.*;
import java.awt.*;

import controller.StudentCon;
import model.Student;

public class StudentView extends BaseView {
    
    private StudentCon sc;
    private JButton anmälButton, hoppavButton, seKurserButton, seBetygButton;
    StudentListView studentlist;

    
    public StudentView(StudentCon sc) {
        super("Student");
        this.sc = sc;
        setLayout(new BorderLayout());
        setBackground(Color.DARK_GRAY);
        initComponents();

        
    }
    
    public void initComponents() {
        studentlist = new StudentListView(sc);
        studentlist.setVisible(false);
        
        anmälButton = new JButton("Anmäl");
        hoppavButton = new JButton("Hoppa väg");
        seKurserButton = new JButton("Se kurser");
        seBetygButton = new JButton("Se betyg");
        
        add(studentlist);
        add(anmälButton);
        add(hoppavButton);
        add(seKurserButton);
        add(seBetygButton);
    }

}