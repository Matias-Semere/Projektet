package view;

import java.awt.*;
import javax.swing.*;
import controller.*;
import model.Kurs;
import model.Lärare;
import model.Registrering;
import view.lists.*;

public class LärareView extends BaseView {

    private LärareCon lc;
    private StudentCon sc;
    private RapporteringCon rc;
    private RegistreringCon rpc;
    private JButton läggtillStudent, taBortStudent, RaporteraBetyg;
    private StudentLista studenter;
    private KurstillfälleLista kurstillfälleLista;

    public LärareView(String user, LärareCon lc, RapporteringCon rc, RegistreringCon rpc) {
        super("Välkommen Lärare: " + user);
        this.lc = lc;
        this.rc = rc;
        this.rpc = rpc;
        setBackground(Color.DARK_GRAY);
        initComponents();
    }

    public void initComponents() {
        läggtillStudent = new JButton("Lägg till Student");
        taBortStudent = new JButton("Ta bort Student");
        RaporteraBetyg = new JButton("Rapportera Betyg");
        studenter = new StudentLista(sc);

        contentPanel.add(studenter);
        footerPanel.add(läggtillStudent);
        footerPanel.add(taBortStudent);        
        footerPanel.add(RaporteraBetyg);
    }
}