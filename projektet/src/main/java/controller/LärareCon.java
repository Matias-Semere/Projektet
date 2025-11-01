package controller;

import dao.LärareDAO;
import model.Lärare;

public class LärareCon extends BaseController<Lärare> {
    // LärareDAO dao;

    public LärareCon(LärareDAO lärareDao) {
        super(lärareDao);
        // this.dao = lärareDao;
    }

}
