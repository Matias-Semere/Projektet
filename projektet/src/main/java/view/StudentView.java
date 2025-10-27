package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Scanner;

import controller.MainController;
import controller.StudentCon;
import model.Student;

public class StudentView extends JPanel {
    
    private MainController mc = new MainController();
    private StudentCon sc;
    private JButton addButton, removeButton, UpdateListButton, showLoginButton;
    private DefaultListModel<String> listan = new DefaultListModel<String>();
    private JList<String> StudentJList = new JList<String>(listan);
    private JScrollPane StudentScroll = new JScrollPane(StudentJList);
    private String htmlstyle = "<html><style> h3 {color: White; border: 10px solid black; padding: 10px;}</style> <h3>";
    
    private ActionListener update = e -> {
        listan.clear();
        sc.getListOfStudents().forEach(s -> listan.addElement(htmlstyle + s.toString()));
        StudentJList.setModel(listan);
    };
    
    public StudentView(StudentCon sc) {
        this.sc = sc;
        setBackground(Color.DARK_GRAY);
        initComponents();
        StudentJList.setBackground(Color.DARK_GRAY);
        add(addButton);
        add(removeButton);
        add(UpdateListButton);
        add(StudentScroll);
        add(showLoginButton);
        mc.addJobb(() -> {
            listan.clear();
            sc.getListOfStudents().forEach(s -> listan.addElement(htmlstyle + s.toString()));
            StudentJList.setModel(listan);
        });
    }

    public void initComponents() {
        addButton = new JButton("Lägg till Student");
        removeButton = new JButton("Tabort Student");
        UpdateListButton = new JButton("Uppdatera Listan");
        showLoginButton = new JButton("Visa Login");

        showLoginButton.addActionListener(e -> {
            new Loggin();
        });

        StudentScroll.setPreferredSize(new Dimension(500, 800));
        StudentScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        addButton.addActionListener(e -> {
            // nextStudentID = sc.getStudentCount() + 1;
            sc.insertStudent(new Student("Matias", 2003, 2));
            mc.work();
        });
        removeButton.addActionListener(e -> {
            int ID;
            if(StudentJList.getSelectedIndex() != -1) {
                Scanner s = new Scanner(StudentJList.getSelectedValue());
                s.next();
                String temp2 = s.next();

                String temp = temp2.substring(0, temp2.indexOf(','));

                ID = Integer.parseInt(temp);
                System.out.println(temp);
                sc.deleteStudentByID(ID);
                s.close();
            }
            mc.work();
        });
        UpdateListButton.addActionListener(update);
    }

}