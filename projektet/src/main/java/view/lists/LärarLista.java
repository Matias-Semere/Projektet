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
    public void updateList(List<Lärare> allLärare) {
        listModel.clear();
        for (Lärare lärare : allLärare) {
            listModel.addElement(formatItem(lärare)); // Format student and add to list
        }
    }

    @Override
    protected void onAddButtonClicked() {
        String name = JOptionPane.showInputDialog(this, "Enter student name:");
        if (name != null && !name.isEmpty()) {
            System.out.println("Adding student: " + name);
        }
    }

    @Override
    protected String formatItem(Lärare Lärare) {
        return style + Lärare.getNamn() + " (ID: " + Lärare.getID() + ")";
    }
}

