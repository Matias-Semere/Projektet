package view;

import java.awt.*;
import javax.swing.*;
import controller.*;
import model.Lärare;

import view.lists.*;

public class LärareView extends BaseView {

    private LärareCon lc;
    private StudentCon sc;
    private JButton läggtillStudent, taBortStudent, RaporteraBetyg;
    private StudentLista studenter;

    public LärareView(String user, LärareCon lc, StudentCon sc , RapporteringCon rc) {
        super("Välkommen Lärare: " + user);
        this.lc = lc;
        this.sc = sc;
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