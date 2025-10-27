package model;

public class Betyg {
    private int BetygID;
    private int StudentID;
    private int MomentID;
    private MomentBetyg värde2;

    public Betyg(int StudentID) {
        this.StudentID = StudentID;
    }



    public enum MomentBetyg {
        VG, G, U;
    }



    public void sättBetygPåMoment(MomentBetyg betyg, int MomentID) {
        this.MomentID = MomentID;

        värde2 = betyg;
    }

    public String toString() {
        return värde1 + " " + värde2;
    }

}
