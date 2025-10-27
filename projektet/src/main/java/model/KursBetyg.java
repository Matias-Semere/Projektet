package model;

public class KursBetyg extends Betyg {

    private KursBetyg värde1;

    public enum Betyg {
        A, B, C, D, E, F;
    }

    public KursBetyg() {
        
    }

    public void sättBetygPåKurs(KursBetyg betyg, int BetygID) {
        this.BetygID = BetygID;

        värde1 = betyg;
    }

}
