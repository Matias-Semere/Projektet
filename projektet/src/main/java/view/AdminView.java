package view;

import java.awt.*;
import javax.swing.*;
import controller.AdminCon;

public class AdminView extends BaseView {

    private AdminCon ac;
    private JButton addTeacher, removeTeacher, addStudent, removeStudent, svararRapport;

    public AdminView(AdminCon adminCon) {
        super("Admin");
        this.ac = adminCon;
        setSize(500, 500);
        setBackground(Color.DARK_GRAY);
        initComponents();
    }

    public void initComponents() {
        addTeacher = new JButton("Lägg till lärare");
        removeTeacher = new JButton("Ta bort lärare");
        addStudent = new JButton("Lägg till student");
        removeStudent = new JButton("Ta bort student");
        svararRapport = new JButton("Svara rapportering");
        contentPanel.add(addTeacher);
        contentPanel.add(removeTeacher);
        contentPanel.add(addStudent);
        contentPanel.add(removeStudent);
        contentPanel.add(svararRapport);
        contentPanel.setVisible(false);
    }

}
