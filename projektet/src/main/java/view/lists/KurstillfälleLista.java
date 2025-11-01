package view.lists;

import javax.swing.*;
import java.awt.*;

import java.util.List;
import controller.KurstillfälleCon;
// import model.Kurstillfälle;


public class KurstillfälleLista extends BaseList<String> {

    private KurstillfälleCon k;

    public KurstillfälleLista(KurstillfälleCon k) {
        this.k = k;
        scrollPane.setPreferredSize(new Dimension(700, 800));
        updateList(k.getAllWithCourseNames());
    }

    @Override
    protected void onAddButtonClicked() {
        updateList(k.getAllWithCourseNames());
    }

    @Override
    public void updateList(List<String> items) {
        listModel.clear();
        int i = 1;
        for (String item : items) {
            if (item.length() > 60) {
                listModel.addElement(style + item.substring(0, 60) + "..." + " (ID:" + i + ")");
            } else {
                listModel.addElement(style + item + " (ID:" + i + ")");
            }
            i++;
        }
    }

}
