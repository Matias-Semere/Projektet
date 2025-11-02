package controller;

import dao.LärareDAO;
import model.Lärare;

public class LärareCon extends BaseController<Lärare> {
    LärareDAO dao;
    StudentCon sc;

    public LärareCon(LärareDAO lärareDao, StudentCon sc) {
        super(lärareDao);
        this.dao = lärareDao;
        this.sc = sc;
    }

    public Lärare getbyName(String namn) {
        return dao.getByName(namn);
    }

    public StudentCon getSc() {
        return sc;
    }

}
