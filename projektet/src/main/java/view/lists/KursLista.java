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
        scrollPane.setPreferredSize(new Dimension(600, 800));
        updateList(kc.getAll());
    }

    @Override
    protected void onAddButtonClicked() {
        updateList(kc.getAll());
    }

    @Override
    public void updateList(List<Kurs> kurser) {
        listModel.clear();
        for (Kurs kursen : kurser) {
            listModel.addElement(formatItem(kursen));
        }
    }

    @Override
    protected String formatItem(Kurs kursen) {
        if (kursen.getNamn().length() > 60) {
            return style + kursen.getNamn().substring(0, 60) + "..." + " (ID: " + kursen.getID() + ")";
        }
        return style + kursen.getNamn() + " (ID: " + kursen.getID() + ")";
    }

}
