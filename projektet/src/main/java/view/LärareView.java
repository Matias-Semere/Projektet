package view;

import java.awt.*;
import javax.swing.*;
import controller.*;
import model.*;
import dao.*;
import view.lists.*;
import java.util.ArrayList;
import java.util.List;

public class LärareView extends BaseView {

    private LärareCon lc;
    private RapporteringCon rc;
    private RegistreringCon rpc;
    private LärarTilldelningCon ltc;
    private JButton läggtillStudent, taBortStudent, RaporteraBetyg;
    private StudentLista studenter;
    private KurstillfälleLista kurstillfälleLista;
    private KurstillfälleCon kfc;

    public LärareView(String user, LärareCon lc, RapporteringCon rc, RegistreringCon rpc, KurstillfälleCon kfc, LärarTilldelningCon ltc) {
        super("Välkommen Lärare: " + user);
        this.lc = lc;
        this.rc = rc;
        this.rpc = rpc;
        this.kfc = kfc;
        // this.user = user;
        this.ltc = ltc;

        studenter = new StudentLista(lc.getSc());
        kurstillfälleLista = new KurstillfälleLista(kfc, ltc, lc.getbyName(user));
        minakurser(lc.getbyName(user));
        
        setBackground(Color.DARK_GRAY);
        initComponents();
    }

    
    public void initComponents() {
        läggtillStudent = new JButton("Lägg till Student");
        taBortStudent = new JButton("Ta bort Student");
        RaporteraBetyg = new JButton("Rapportera Betyg");
        studenter = new StudentLista(lc.getSc());
        
        JButton knapp = new JButton("knapp");
        // knapp.addActionListener(e -> minakurser(lc.getbyName(user)));

        contentPanel.add(studenter);
        contentPanel.add(kurstillfälleLista);
        footerPanel.add(läggtillStudent);
        footerPanel.add(taBortStudent);        
        footerPanel.add(RaporteraBetyg);
        footerPanel.add(knapp);
    }
    
    public void minakurser(Lärare l) {
        List<Kurstillfälle> kt = new ArrayList<>();
        List<LärarTilldelning> lt = ltc.getForLärare(l);

        for (LärarTilldelning lti : lt) {
            kt.add(kfc.getById(lti.getKurstillfälleId()));
        }
        kurstillfälleLista.updateList(kt);
    }

}