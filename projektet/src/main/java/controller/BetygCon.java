package controller;

import dao.BetygDAO;
import model.Betyg;
import java.util.List;

public class BetygCon {

    BetygDAO dao;

    public BetygCon(BetygDAO dao) {
        this.dao = dao;
    }

    public List<Betyg> getAllBetyg() {
        return dao.getAll();
    }

    public void insertBetyg(Betyg betyg) {
        dao.insert(betyg);
    }

    public void deleteBetyg(Betyg betyg) {
        dao.delete(betyg);
    }

    public void alterBetyg(Betyg betyg) {
        dao.update(betyg);
    }
}
