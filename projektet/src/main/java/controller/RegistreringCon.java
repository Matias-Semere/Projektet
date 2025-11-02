package controller;

import java.util.List;

import dao.RegistreringDAO;
import model.Registrering;

public class RegistreringCon extends BaseController<Registrering> {
        
    private RegistreringDAO dao;

    public RegistreringCon(RegistreringDAO r) {
        super(r);
        this.dao = r;
    }

    public List<Registrering> getByStudentID(int studentID) {
        return dao.getByStudentID(studentID);
    }

}
