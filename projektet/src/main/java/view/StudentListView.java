package view;

import javax.swing.*;
import java.awt.*;
import model.Student;
import controller.StudentCon;

public class StudentListView extends JPanel {

    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> studentList = new JList<String>(listModel);
    private JScrollPane scrollPane = new JScrollPane(studentList);

    private StudentCon sc;

    private String htmlstyle = "<html><style> h3 {color: White; border: 10px solid black; padding: 10px;}</style> <h3>";

    public StudentListView(StudentCon sc) {
        this.sc = sc;
        setBackground(Color.DARK_GRAY);
        initComponents();
    }

    public void initComponents() {
        scrollPane.setPreferredSize(new Dimension(500, 800));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        studentList.setBackground(Color.DARK_GRAY);
        add(scrollPane);
    }

    public void refreshStudentList() {
        listModel.clear();
        for (Student s : sc.getListOfStudents()) {
            listModel.addElement(htmlstyle + s);
        }
    }

}
