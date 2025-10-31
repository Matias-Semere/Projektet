package controller;

import java.util.List;

import dao.KurstilfälleDAO;
import model.Kurstillfälle;

public class KurstillfälleCon {
    KurstilfälleDAO dao;

    public KurstillfälleCon(KurstilfälleDAO k) {
        this.dao = k;
    }

    public List<Kurstillfälle> getAllKurstillfällen() {
        return dao.getAllKurstillfälle();
    }

    public void insertKurstillfälle(Kurstillfälle kurstillfälle) {
        dao.insertKurstillfälle(kurstillfälle);
    }

    public void deleteKurstillfälle(Kurstillfälle kurstillfälle) {
        dao.deleteKurstillfälle(kurstillfälle);
    }

    public void alterKurstillfälle(Kurstillfälle kurstillfälle) {
        dao.alterKurstillfälle(kurstillfälle);
    }

}
