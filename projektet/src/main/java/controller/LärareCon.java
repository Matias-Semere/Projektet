package controller;

import dao.LärareDAO;
import model.Lärare;

public class LärareCon extends BaseController<Lärare> {
    
    public LärareCon(LärareDAO lärareDao) {
        super(lärareDao);
        // this.dao = lärareDao;
    }

}
