package controller;

import java.util.List;

import dao.KursDAO;
import model.Kurs;

public class KursCon {
    KursDAO dao;

    public KursCon(KursDAO k) {
        this.dao = k;

    }

    public void insertKurs(Kurs kurs) {
        dao.insertKurs(kurs);
    }

    public void deleteKurs(Kurs kurs) {
        dao.deleteKurs(kurs);
    }

    public List<Kurs> getAllKurser() {
        return dao.getAllKurs();
    }

    public void alterKurs(Kurs kurs) {
        dao.alterKurs(kurs);
    }
}
