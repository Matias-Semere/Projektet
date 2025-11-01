package view;

import javax.swing.*;
import java.awt.*;

import controller.KurstillfälleCon;
import controller.StudentCon;
import model.Betyg;
import model.Student;
import view.lists.KurstillfälleLista;
import view.lists.StudentLista;

public class StudentView extends BaseView {
    
    private StudentCon sc;
    private JButton anmälButton, hoppavButton, seKurserButton, seBetygButton;
    KurstillfälleLista kurstillfälleLista;

    
    public StudentView(String user, StudentCon sc, KurstillfälleCon kfc) {
        super("Välkommen Student: " + user);
        this.sc = sc;
        kurstillfälleLista = new KurstillfälleLista(kfc);
        setBackground(Color.DARK_GRAY);
        initComponents();
    }
    
    public void initComponents() {
        // Betyg betyg = new Betyg(sc.getStudentID(user));
        
        anmälButton = new JButton("Gör ansökan");
        hoppavButton = new JButton("Hoppa av");
        seKurserButton = new JButton("Se kurser");
        seBetygButton = new JButton("Se betyg");
        
        style(anmälButton);
        style(hoppavButton);

        contentPanel.add(kurstillfälleLista);
        footerPanel.add(anmälButton);
        footerPanel.add(hoppavButton);
        // footerPanel.add(seKurserButton);
        // footerPanel.add(seBetygButton);
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