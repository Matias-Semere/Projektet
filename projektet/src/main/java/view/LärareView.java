package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.LärareCon;
import controller.MainController;
import model.Lärare;

public class LärareView extends JPanel {

    private MainController mc = new MainController();
    private LärareCon lc;
    private JButton addButton, removeButton, UpdateListButton, showLoginButton;
    private DefaultListModel<String> listan = new DefaultListModel<String>();
    private JList<String> lärareJList = new JList<String>(listan);
    private JScrollPane läraretScroll = new JScrollPane(lärareJList);
    private String htmlstyle = "<html><style> h3 {color: White; border: 10px solid black; padding: 10px;}</style> <h3>";

    private ActionListener update = e -> {
        listan.clear();
        lc.getListOfLärare().forEach(s -> listan.addElement(htmlstyle + s.toString()));
        lärareJList.setModel(listan);
    };

    public LärareView(LärareCon lc) {
        this.lc = lc;
        setBackground(Color.DARK_GRAY);
        initComponents();
        lärareJList.setBackground(Color.DARK_GRAY);
        add(addButton);
        add(removeButton);
        add(UpdateListButton);
        add(lärareJList);
        add(showLoginButton);
        mc.addJobb(() -> {
            listan.clear();
            lc.getListOfLärare().forEach(s -> listan.addElement(htmlstyle + s.toString()));
            lärareJList.setModel(listan);
        });
    }

    public void initComponents() {
        addButton = new JButton("Lägg till lärare");
        removeButton = new JButton("Tabort lärare");
        UpdateListButton = new JButton("Uppdatera Listan");
        showLoginButton = new JButton("Visa Login");

        showLoginButton.addActionListener(e -> {
            new Loggin();
        });

        lärareJList.setPreferredSize(new Dimension(500, 800));
        // lärareJList.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        addButton.addActionListener(e -> {
            // nextStudentID = lc.getStudentCount() + 1;
            lc.insertLärare(new Lärare(2, "Matias", 2000, 2));
            mc.work();
        });
        removeButton.addActionListener(e -> {
            int ID;
            if (lärareJList.getSelectedIndex() != -1) {
                Scanner s = new Scanner(lärareJList.getSelectedValue());
                s.next();
                String temp2 = s.next();

                String temp = temp2.substring(0, temp2.indexOf(','));

                ID = Integer.parseInt(temp);
                System.out.println(temp);
                // lc.deleteLärare();
                s.close();
            }
            mc.work();
        });
        UpdateListButton.addActionListener(update);
    }
}