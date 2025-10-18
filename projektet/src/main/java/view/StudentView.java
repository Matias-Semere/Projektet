package view;

import javax.swing.*;
import java.awt.*;

import controller.StudentCon;
import model.Student;

public class StudentView extends JFrame {

    StudentCon sc = new StudentCon();
    String allStudents = "";
    int nextStudentID = 0;

    public StudentView() {
        setTitle("Student Database");
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setSize(500, 500);
        panel.setBackground(Color.orange);
        JButton button = new JButton("Se Studenter i Listan");
        JButton addButton = new JButton("Lägg till Student");
        addButton.addActionListener(e -> {
            nextStudentID = sc.getStudentCount() + 1;
            sc.insertStudent(new Student(nextStudentID, "InsertTest", 1999, 3));
        });
        
        DefaultListModel<String> listan = new DefaultListModel<String>();
        JList<String> listan2 = new JList<String>(listan);
        JScrollPane listanscroll = new JScrollPane(listan2);
        listanscroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        button.addActionListener(e -> {
            for (int i = 0; i < sc.getStudentCount(); i++) {
                listan.addElement(sc.getStudentbyID(i));
            }
            listanscroll.setSize(getPreferredSize());
        });

        panel.add(addButton);
        panel.add(button);
        panel.add(listanscroll);
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        StudentView sv = new StudentView();
    }
}
