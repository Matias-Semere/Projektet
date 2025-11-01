package view.lists;

import controller.LärareCon;
import model.Lärare;

import java.util.List;

public class LärareLista extends BaseList<Lärare> {
    private List<Lärare> entityList;
    private LärareCon lc;

    public LärareLista(LärareCon lc) {
        this.lc = lc;
        updateList(lc.getAll());
    }

    @Override
    public void updateList(List<Lärare> allLärare) {
        entityList = allLärare;
        listModel.clear();
        for (Lärare l : allLärare) {
            listModel.addElement(l);
        }
    }

    @Override
    protected void onAddButtonClicked() {
        updateList(entityList);
    }

    public Lärare getSelectedEntity() {
        int index = listView.getSelectedIndex();
        if (index >= 0 && index < entityList.size()) {
            return entityList.get(index);
        }
        return null;
    }

    @Override
    protected String formatItem(Lärare lärare) {
        return lärare.getNamn() + " (ID: " + lärare.getID() + ")";
    }
}
