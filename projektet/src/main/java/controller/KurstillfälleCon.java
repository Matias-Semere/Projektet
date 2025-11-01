
package controller;

import java.util.List;

import dao.KurstillfälleDAO;
import model.Kurstillfälle;

public class KurstillfälleCon {
    KurstillfälleDAO dao;

    public KurstillfälleCon(KurstillfälleDAO k) {
        this.dao = k;
    }

    public List<Kurstillfälle> getAllKurstillfällen() {
        return dao.getAll();
    }

    public void insertKurstillfälle(Kurstillfälle kurstillfälle) {
        dao.insert(kurstillfälle);
    }

    public void deleteKurstillfälle(Kurstillfälle kurstillfälle) {
        dao.delete(kurstillfälle);
    }

    public void alterKurstillfälle(Kurstillfälle kurstillfälle) {
        dao.update(kurstillfälle);
    }

}
