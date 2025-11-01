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
    private DefaultListModel<String> listan = new DefaultListModel<String>();
    private JList<String> lärareJList = new JList<String>(listan);
    private JScrollPane läraretScroll = new JScrollPane(lärareJList);
    private String htmlstyle = "<html><style> h3 {color: White; border: 10px solid black; padding: 10px;}</style> <h3>";
    private StudentLista studenter;

    public LärareView(LärareCon lc, StudentCon sc, String user) {
        super("Lärare: " + user);
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
        contentPanel.add(läggtillStudent);
        contentPanel.add(taBortStudent);        
        contentPanel.add(RaporteraBetyg);
    }



    
}