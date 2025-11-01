package controller;

import java.util.List;

import dao.KurstillfälleDAO;
import model.Kurstillfälle;

public class KurstillfälleCon extends BaseController<Kurstillfälle> {

    private KurstillfälleDAO customeDOA;

    public KurstillfälleCon(KurstillfälleDAO k) {
        super(k);
        customeDOA = k;
    }

    public List<String> getAllWithCourseNames() {
       return customeDOA.getAllWithCourseNames();
    }

}
