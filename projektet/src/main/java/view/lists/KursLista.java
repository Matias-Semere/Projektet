package view.lists;

import java.util.List;
import javax.swing.*;
import java.awt.*;

import model.Kurs;
import controller.KursCon;



public class KursLista extends BaseList<Kurs> {

    private KursCon kc;

    public KursLista(KursCon kc) {
        this.kc = kc;
        scrollPane.setPreferredSize(new Dimension(600, 700));
        JButton addButton = new JButton("Skapa");
        JButton removeButton = new JButton("Ta bort");
        styleButton(addButton);
        styleButton(removeButton);
        addButton.addActionListener(e -> onAddKurs());
        removeButton.addActionListener(e -> onDelKurs());
        updateButton.addActionListener(e -> getAll());
        actionPanel.add(addButton);
        actionPanel.add(removeButton);
        updateList(kc.getAll());
    }

    protected void getAll() {
        updateList(kc.getAll());
    }

    public void onAddKurs() {
        String namn = JOptionPane.showInputDialog(null, "Skriv in namn:");
        String kurskod = JOptionPane.showInputDialog(null, "Skriv in kurskod:");
        double högskolepoäng = Double.parseDouble(JOptionPane.showInputDialog(null, "Skriv in högskolepoäng:"));

        Kurs kurs = new Kurs(namn, kurskod, högskolepoäng);
        kc.insert(kurs);
        updateList(kc.getAll());
    }

    public void onDelKurs() {
        Kurs k = this.getSelectedEntity();
        if (k != null) {
            kc.delete(k);
        }
        updateList(kc.getAll());
    }

    @Override
    public void updateList(List<Kurs> kurser) {
        listModel.clear();
        for (Kurs kursen : kurser) {
            listModel.addElement(kursen);
        }
    }

}
