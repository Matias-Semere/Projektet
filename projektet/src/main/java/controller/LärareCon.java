package controller;

import java.util.List;

import dao.LärareDAO;
import model.Lärare;

public class LärareCon {
    LärareDAO dao;

    public LärareCon(LärareDAO lärareDao) {
        this.dao = lärareDao;
    }

    public void insertLärare(Lärare lärare) {
        dao.insert(lärare);
    }

    public void deleteLärare(Lärare lärare) {
        dao.delete(lärare);
    }

    public void updateLärare(Lärare lärare) {
        dao.update(lärare);
    }

    public List<Lärare> getListOfLärare() {
        return dao.getAll();
    }

}
