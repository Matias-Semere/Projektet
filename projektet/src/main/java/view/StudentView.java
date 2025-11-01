package view;

import javax.swing.*;
import java.awt.*;

import controller.StudentCon;
import model.Student;
import view.lists.StudentLista;

public class StudentView extends BaseView {
    
    private StudentCon sc;
    private JButton anmälButton, hoppavButton, seKurserButton, seBetygButton;
    StudentLista studentlist;

    
    public StudentView(StudentCon sc, String user) {
        super("Student: " + user);
        this.sc = sc;
        setBackground(Color.DARK_GRAY);
        initComponents();
    }
    
    public void initComponents() {
        studentlist = new StudentLista(sc);
        studentlist.setVisible(false);
        
        anmälButton = new JButton("Gör ansökan");
        hoppavButton = new JButton("Hoppa av");
        seKurserButton = new JButton("Se kurser");
        seBetygButton = new JButton("Se betyg");
        
        contentPanel.add(studentlist);
        contentPanel.add(anmälButton);
        contentPanel.add(hoppavButton);
        contentPanel.add(seKurserButton);
        contentPanel.add(seBetygButton);
    }

}