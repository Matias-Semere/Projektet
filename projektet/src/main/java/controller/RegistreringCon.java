package controller;

import dao.RegistreringDAO;
import model.Registrering;

public class RegistreringCon extends BaseController<Registrering> {
        
    public RegistreringCon(RegistreringDAO r) {
        super(r);
    }
}
