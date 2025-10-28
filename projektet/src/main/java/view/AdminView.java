package view;

import java.awt.*;
import java.util.Map;

import javax.swing.*;

import controller.AdminCon;
import model.Betyg;
import model.Student;
import model.Betyg.Grades;

public class AdminView extends JPanel {
    // Betyg betyg;

    private AdminCon ac;
    private DefaultListModel<Student> listModel = new DefaultListModel<>();
    private JList<Student> studentList = new JList<Student>(listModel);
    private JScrollPane scrollPane = new JScrollPane(studentList);
    private JComboBox<Enum> selectGrade;
    private JLabel valdStudentLabel;
    private JButton addButton;
    private Map<String, String> studentBetyg;
    private JTextField studentID = new JTextField();
    private String htmlstyle = "<html><style> h3 {color: White; border: 10px solid black; padding: 10px;}</style> <h3>";

    public AdminView(AdminCon adminCon) {
        this.ac = adminCon;
        initComponents();
        studentList.addListSelectionListener(e -> {
            Object sel = selectGrade.getSelectedItem();
            Grades grade = (Grades) sel;
            Betyg betyg = new Betyg(12, 13, grade);
            System.out.println(betyg);
        });

        add(selectGrade);
        add(studentID);
        add(studentList);

        setSize(500, 500);
        setBackground(Color.DARK_GRAY);

    }

    public void initComponents() {
        Betyg.Grades grades[] = { Betyg.Grades.A, Betyg.Grades.B, Betyg.Grades.C,
                Betyg.Grades.D, Betyg.Grades.E, Betyg.Grades.F,
                Betyg.Grades.MVG, Betyg.Grades.VG, Betyg.Grades.G,
                Betyg.Grades.U };

        String[] b = { "A", "B", "C", "D", "E", "F" };
        selectGrade = new JComboBox<>(grades);


        addButton = new JButton("Lägg till Student");
        add(addButton);
    }

}
