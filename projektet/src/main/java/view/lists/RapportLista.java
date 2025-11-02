package view.lists;

import model.Rapportering;
import java.util.List;
import controller.RapporteringCon;


public class RapportLista extends BaseList<Rapportering> {
    
    private RapporteringCon rc;

    public RapportLista(RapporteringCon rc) {
        this.rc = rc;
        updateButton.addActionListener(e -> getAll());
        updateList(rc.getAll());
    }

    public void getAll() {
        updateList(rc.getAll());
    }

    @Override
    public void updateList(List<Rapportering> items) {
        listModel.clear();
        for (Rapportering item : items) {
            listModel.addElement(item);
        }
    }
}
