package controller;

import dao.KurstillfälleDAO;
import model.Kurstillfälle;

public class KurstillfälleCon extends BaseController<Kurstillfälle> {

    public KurstillfälleCon(KurstillfälleDAO k) {
        super(k);
    }

}
