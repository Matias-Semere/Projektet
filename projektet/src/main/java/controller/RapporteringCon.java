package controller;

import java.util.List;
import dao.RapporteringDAO;
import model.Rapportering;

public class RapporteringCon extends BaseController<Rapportering> {
    
    public RapporteringCon(RapporteringDAO r) {
        super(r);
    }   

}
