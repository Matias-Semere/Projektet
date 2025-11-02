package view.lists;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import controller.*;
import model.Kurstillfälle;
import model.LärarTilldelning;
import model.Lärare;

public class KurstillfälleLista extends BaseList<Kurstillfälle> {

    private KurstillfälleCon k;
    private LärarTilldelningCon ltc;

    public KurstillfälleLista(KurstillfälleCon k) {
        this.k = k;
        scrollPane.setPreferredSize(new Dimension(600, 750));
        updateList(k.getAll());
    }

    public KurstillfälleLista(KurstillfälleCon kc, LärarTilldelningCon ltc, Lärare l) {
        this(kc);
        this.ltc = ltc;
        updateButton.addActionListener(e -> correctUpdate(l));
    }

    public List<Kurstillfälle> correctUpdate(Lärare l) {
        List<Kurstillfälle> kt = new ArrayList<>();
        List<LärarTilldelning> lt = ltc.getForLärare(l);
        for (LärarTilldelning lti : lt) {
            kt.add(k.getById(lti.getKurstillfälleId()));
        }
        return kt;
    }

    protected void getAll() {
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
