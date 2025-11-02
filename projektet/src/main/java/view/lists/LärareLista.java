package view.lists;

import controller.LärareCon;
import model.Lärare;
import java.util.List;


public class LärareLista extends BaseList<Lärare> {
    private List<Lärare> entityList;
    private LärareCon lc;

    public LärareLista(LärareCon lc) {
        this.lc = lc;
        updateButton.addActionListener(e -> getAll());
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

    protected void getAll() {
        updateList(entityList);
    }

    public Lärare getSelectedEntity() {
        int index = listView.getSelectedIndex();
        if (index >= 0 && index < entityList.size()) {
            return entityList.get(index);
        }
        return null;
    }

}
