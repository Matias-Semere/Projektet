package controller;

import dao.KursDAO;
import model.Kurs;

public class KursCon extends BaseController<Kurs> {

    public KursCon(KursDAO k) {
        super(k);
    }

    public int getCount() {
        return dao.getAll().size();
    }
    
}
