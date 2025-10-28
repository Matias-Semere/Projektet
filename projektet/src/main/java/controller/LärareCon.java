package controller;

import java.util.List;

import dao.LärareDAO;
import model.Lärare;

public class LärareCon {
    LärareDAO dao;

    public LärareCon(LärareDAO lärareDao) {
        this.dao = lärareDao;
    }

    public List<Lärare> getListOfLärare() {
        return dao.getAllLärare();
    }

    public void deleteLärare(Lärare lärare) {
        dao.deleteLärare(lärare);
    }

    public void insertLärare(Lärare lärare) {
        dao.insertLärare(lärare);
    } 

    public void alterLärare(Lärare lärare){
        dao.alterLärare(lärare);

    }


}
