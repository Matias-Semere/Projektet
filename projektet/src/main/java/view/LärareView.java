package view;

import java.awt.*;
import javax.swing.*;
import controller.LärareCon;
import model.Lärare;

public class LärareView extends BaseView {

    private LärareCon lc;
    private JButton läggtillStudent, taBortStudent, RaporteraBetyg;
    private DefaultListModel<String> listan = new DefaultListModel<String>();
    private JList<String> lärareJList = new JList<String>(listan);
    private JScrollPane läraretScroll = new JScrollPane(lärareJList);
    private String htmlstyle = "<html><style> h3 {color: White; border: 10px solid black; padding: 10px;}</style> <h3>";

    public LärareView(LärareCon lc) {
        super("Lärare");
        this.lc = lc;
        setBackground(Color.DARK_GRAY);
        initComponents();
    }

    public void initComponents() {
        läggtillStudent = new JButton("Lägg till Student");
        taBortStudent = new JButton("Ta bort Student");
        RaporteraBetyg = new JButton("Rapportera Betyg");
        contentPanel.add(läggtillStudent);
        contentPanel.add(taBortStudent);        
        contentPanel.add(RaporteraBetyg);
    }



    
}