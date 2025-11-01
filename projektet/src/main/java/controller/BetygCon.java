package controller;

import dao.BetygDAO;
import model.Betyg;

public class BetygCon extends BaseController<Betyg> {
    public BetygCon(BetygDAO dao) {
        super(dao);
    }

}
