package view;

import javax.swing.*;
import java.awt.*;

public class RapporteringView extends JPanel {

    private JLabel setBetyg, setMoment, setKurs;
    private JButton rapportera;
    private JTextField betyg, moment, kurs;
    
    public void rapportera(int rapporteringsID) {
        initComponents();
        add(setBetyg);
        add(setMoment);
        add(setKurs);
        add(betyg);
        add(moment);
        add(kurs);
        add(rapportera);
    }     

    private void initComponents() {
        setBetyg = new JLabel("Betyg");
        setMoment = new JLabel("Moment");
        setKurs = new JLabel("Kurs");
        rapportera = new JButton("Rapportera");
        betyg = new JTextField();
        moment = new JTextField();
        kurs = new JTextField();
    }
}
