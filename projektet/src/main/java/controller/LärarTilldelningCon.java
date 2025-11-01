package controller;

import java.util.ArrayList;
import java.util.List;

import dao.LärarTilldelningDAO;
import model.Kurstillfälle;
import model.Lärare;
import model.LärarTilldelning;

public class LärarTilldelningCon extends BaseController<LärarTilldelning> {

    private LärarTilldelningDAO dao;

    public LärarTilldelningCon(LärarTilldelningDAO dao) {
        super(dao);
        this.dao = dao;
    }

    public List<LärarTilldelning> getForLärare(Lärare lärare) {
        List<LärarTilldelning> result = new ArrayList<>();
        for (LärarTilldelning lt : dao.getAll()) {
            if (lt.getLärareId() == lärare.getID()) {
                result.add(lt);
            }
        }
        return result;
    }

     public void deleteByLärareAndKurstillfälle(int lärareID, int kurstillfälleID) {
        dao.deleteByLärareAndKurstillfälle(lärareID, kurstillfälleID);
    }

    public List<LärarTilldelning> getForKurstillfälle(Kurstillfälle kf) {
        List<LärarTilldelning> result = new ArrayList<>();
        for (LärarTilldelning lt : dao.getAll()) {
            if (lt.getKurstillfälleId() == kf.getID()) {
                result.add(lt);
            }
        }
        return result;
    }
}
