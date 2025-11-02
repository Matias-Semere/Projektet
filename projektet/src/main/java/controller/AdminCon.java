package controller;

import model.LärarTilldelning;
import model.Admin;
import dao.AdminDAO;

public class AdminCon extends BaseController<Admin> {
    private LärarTilldelningCon lärarTilldelningCon;
    private KursCon kc;

    public AdminCon(AdminDAO adminDao, LärarTilldelningCon lärarTilldelningCon, KursCon kc) {
        super(adminDao);
        this.lärarTilldelningCon = lärarTilldelningCon;
        this.kc = kc;
    }

    public LärarTilldelningCon getLtc() {
        return lärarTilldelningCon;
    }

    public KursCon getKc() {
        return kc;
    }

    public void assignTeacher(int lärareID, int kurstillfälleID) {
        lärarTilldelningCon.insert(new LärarTilldelning(lärareID, kurstillfälleID));
    }

    public void removeTeacher(int lärareID, int kurstillfälleID) {
        lärarTilldelningCon.deleteByLärareAndKurstillfälle(lärareID, kurstillfälleID);
    }
}
