package controller;

import model.LärarTilldelning;
import model.Admin;
import dao.AdminDAO;

public class AdminCon extends BaseController<Admin> {
    private LärarTilldelningCon lärarTilldelningCon;

    public AdminCon(AdminDAO adminDao, LärarTilldelningCon lärarTilldelningCon) {
        super(adminDao);
        this.lärarTilldelningCon = lärarTilldelningCon;
    }

    public void assignTeacher(int lärareID, int kurstillfälleID) {
        lärarTilldelningCon.insert(new LärarTilldelning(lärareID, kurstillfälleID));
    }

    public void removeTeacher(int lärareID, int kurstillfälleID) {
        lärarTilldelningCon.deleteByLärareAndKurstillfälle(lärareID, kurstillfälleID);
    }
}
