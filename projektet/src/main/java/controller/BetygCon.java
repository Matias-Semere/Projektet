package controller;

import dao.BetygDAO;
import model.Betyg;

public class BetygCon {

    BetygDAO dao;

    public void insertBetyg(Betyg betyg) {
        dao.insertBetyg(betyg);
    }

    public void deleteBetyg(Betyg betyg) {
        dao.deleteBetyg(betyg);
    }

    public void alterBetyg(Betyg betyg) {
        dao.alterBetyg(betyg);
    }
}
