package view;

import java.awt.BorderLayout;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.AdminCon;
import controller.MainController;
import model.Betyg;
import model.Student;

public class AdminView extends JPanel {
    Betyg betyg;

    private MainController mc = new MainController();
    private AdminCon ac;
    private JList<Student> studentList;
    private DefaultListModel<String> listModel;
    private JComboBox<Enum> selectGrade;
    private JLabel valdStudentLabel;
    private Map<String, String> studentBetyg;
    private JTextField studentID = new JTextField();
    private String htmlstyle = "<html><style> h3 {color: White; border: 10px solid black; padding: 10px;}</style> <h3>";
    JFrame frame = new JFrame();

    public AdminView(AdminCon adminCon) {
        this.ac = adminCon;

        frame.setTitle("Adminvy");
        add(selectGrade);
        add(studentID);
        add(studentList);
        Betyg.Grades grades[] = { Betyg.Grades.A, Betyg.Grades.B, Betyg.Grades.C,
                Betyg.Grades.D, Betyg.Grades.E, Betyg.Grades.F,
                Betyg.Grades.MVG, Betyg.Grades.VG, Betyg.Grades.G,
                Betyg.Grades.U };

        String[] b = { "A", "B", "C", "D", "E", "F" };
        selectGrade = new JComboBox<>(grades);

        listModel = new DefaultListModel<>();

        studentList.addListSelectionListener(e -> {
            betyg.setGrade(selectGrade.getSelectedItem());
            betyg = new Betyg(12, 13, selectGrade.getSelectedItem());

        });

    }

}
