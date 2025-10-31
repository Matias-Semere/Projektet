package view;

import java.awt.*;
import javax.swing.*;
import controller.AdminCon;
import model.Kurstillfälle;

public class AdminView extends BaseView {

    private AdminCon ac;
    private JButton addKurstillfälle,  removeKurstillfälle, connectTeacher, disconnectTeacher, svararRapport;

    public AdminView(AdminCon adminCon) {
        super("Admin");
        this.ac = adminCon;
        setSize(500, 500);
        setBackground(Color.DARK_GRAY);
        initComponents();

        // addKurstillfälle.addActionListener(e -> ac.insertKurstillfälle(new Kurstillfälle(1, 1, "2021-01-01")));

    }

    public void initComponents() {
        addKurstillfälle = new JButton("Lägg till Kurstillfälle");
        removeKurstillfälle = new JButton("Ta bort Kurstillfälle");
        connectTeacher = new JButton("Lägg till Lärare");
        disconnectTeacher = new JButton("Ta bort Lärare");
        svararRapport = new JButton("Svara rapportering");
        contentPanel.add(addKurstillfälle);
        contentPanel.add(removeKurstillfälle);
        contentPanel.add(connectTeacher);
        contentPanel.add(disconnectTeacher);
        contentPanel.add(svararRapport);
        contentPanel.setVisible(false);
    }

}
