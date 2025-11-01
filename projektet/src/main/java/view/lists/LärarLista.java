package view.lists;

import javax.swing.*;
import model.Lärare;
import controller.LärareCon;
import java.util.List;

public class LärarLista extends BaseList<Lärare> {

    private LärareCon lc;

    public LärarLista(LärareCon lc) {
        this.lc = lc;
        updateList(lc.getAll());
    }

    @Override
    protected void onAddButtonClicked() {
        updateList(lc.getAll());
    }

    @Override
    public void updateList(List<Lärare> allLärare) {
        listModel.clear();
        for (Lärare lärare : allLärare) {
            listModel.addElement(formatItem(lärare));
        }
    }

    @Override
    protected String formatItem(Lärare Lärare) {
        return style + Lärare.getNamn() + " (ID: " + Lärare.getID() + ")";
    }
}
