package view;

import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;
import java.util.List;

import controller.KurstillfälleCon;
import controller.RegistreringCon;
import controller.StudentCon;
import model.Betyg;
import model.Kurs;
import model.Kurstillfälle;
import model.Registrering;
import model.Student;
import view.lists.KurstillfälleLista;
import view.lists.StudentLista;

public class StudentView extends BaseView {
    
    private StudentCon sc;
    private RegistreringCon rc;
    private KurstillfälleCon kfc;
    private JButton anmälButton, hoppavButton, seKurserButton, seBetygButton;
    KurstillfälleLista kurstillfälleLista;
    KurstillfälleLista minakurstillfällen;

    
    public StudentView(String user, StudentCon sc, KurstillfälleCon kfc, RegistreringCon rc) {
        super("Välkommen Student: " + user);
        this.sc = sc;
        this.rc = rc;
        this.kfc = kfc;
        kurstillfälleLista = new KurstillfälleLista(kfc);

        minakurstillfällen = new KurstillfälleLista(kfc);

        Student s = sc.getById(122);
        minakurser(s);

        setBackground(Color.DARK_GRAY);
        initComponents();
    }
    
    public void initComponents() {
        anmälButton = new JButton("Gör ansökan");
        hoppavButton = new JButton("Hoppa av");
        seKurserButton = new JButton("Se kurser");
        seBetygButton = new JButton("Se betyg");
        
        style(anmälButton);
        style(hoppavButton);
        style(seBetygButton);
        // sc.getById()
        // minakurser();

        contentPanel.add(minakurstillfällen);
        contentPanel.add(kurstillfälleLista);
        footerPanel.add(anmälButton);
        footerPanel.add(hoppavButton);
        footerPanel.add(seBetygButton);
    }

    public void minakurser(Student s) {
        List<Kurstillfälle> kt = new ArrayList<>();

        List<Registrering> lt = rc.getByStudentID(s.getID());
        for (Registrering lti : lt) {
            kt.add(kfc.getById(lti.getKurstillfälleID()));
        }
        kurstillfälleLista.updateList(kt);
    }

    private void style(JButton button) {
        if (button instanceof JButton) {
            button.setBackground(Color.DARK_GRAY);
            button.setForeground(Color.WHITE);
            button.setFont(new Font("Segoe UI", Font.BOLD, 18));
            button.setFocusable(false);
        }
    }

}