package view.lists;

import model.LärarTilldelning;
import controller.LärarTilldelningCon;
import java.util.List;

public class LärarTilldelningLista extends BaseList<LärarTilldelning> {

    private LärarTilldelningCon lc;

    public LärarTilldelningLista(LärarTilldelningCon lc) {
        this.lc = lc;
        updateList(lc.getAll());
    }

    @Override
    public void updateList(List<LärarTilldelning> items) {
        listModel.clear();
        for (LärarTilldelning t : items) {
            listModel.addElement(t);
        }
    }

    @Override
    protected void onAddButtonClicked() {
        updateList(lc.getAll());
    }

    @Override
    protected String formatItem(LärarTilldelning t) {
        return style + "LärareID: " + t.getLärareId() +
               " → KurstillfälleID: " + t.getKurstillfälleId();
    }
}
