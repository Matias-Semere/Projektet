package controller;

import java.util.List;

import dao.KursDAO;
import model.Kurs;

public class KursCon {
    KursDAO dao;

    public KursCon(KursDAO k) {
        this.dao = k;
    }

    public List<Kurs> getAllKurser() {
        return dao.getAll();
    }

    public void insertKurs(Kurs kurs) {
        dao.insert(kurs);
    }

    public void deleteKurs(Kurs kurs) {
        dao.delete(kurs);
    }

    public void alterKurs(Kurs kurs) {
        dao.update(kurs);
    }
}
