package view;

import javax.swing.*;
import java.awt.*;

import controller.StudentCon;
import model.Student;

public class StudentView extends JPanel {
    
    private StudentCon sc;
    private JButton addButton, removeButton, UpdateListButton, showLoginButton;
    StudentListView studentlist;

    
    public StudentView(StudentCon sc) {
        this.sc = sc;
        setBackground(Color.DARK_GRAY);
        
        initComponents();

        studentlist = new StudentListView(sc);
        studentlist.setVisible(false);
        add(studentlist);
        add(UpdateListButton);
        add(showLoginButton);
    }

    public void initComponents() {
        addButton = new JButton("Lägg till Student");
        removeButton = new JButton("Tabort Student");
        UpdateListButton = new JButton("Uppdatera Listan");
        showLoginButton = new JButton("Visa Login");

        addButton.addActionListener(e -> {
            sc.insertStudent(new Student( 3, 100, "Matias", 2));
        });

        // removeButton.addActionListener(e -> studentlist.deleteStudent(new Student("Matias", 2003, 2)));
        removeButton.addActionListener(e -> studentlist.deleteStudentByID());

        UpdateListButton.addActionListener(e -> {
            studentlist.refreshStudentList();
        });


        showLoginButton.addActionListener(e -> {
            // new Loggin();
            studentlist.printStudent();
        });

        add(addButton);
        add(removeButton);

    }

}