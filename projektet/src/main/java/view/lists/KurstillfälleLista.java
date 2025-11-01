package view.lists;

import javax.swing.*;
import java.awt.*;

import java.util.List;
import controller.KurstillfälleCon;
// import model.Kurstillfälle;
import model.Kurstillfälle;


public class KurstillfälleLista extends BaseList<Kurstillfälle> {

    private KurstillfälleCon k;

    public KurstillfälleLista(KurstillfälleCon k) {
        this.k = k;
        scrollPane.setPreferredSize(new Dimension(700, 800));
        updateList(k.getAll());
    }

    @Override
    protected void onAddButtonClicked() {
        updateList(k.getAll());
    }

    @Override
    public void updateList(List<Kurstillfälle> items) {
        listModel.clear();
        for (Kurstillfälle item : items) {
            listModel.addElement(item);
        }
    }

}
