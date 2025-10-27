package model;

public class MomentBetyg extends Betyg {

    public enum mBetyg {
        VG, G, U;
    }

    public MomentBetyg(int StudentID, int MomentID, int BetygID, mBetyg betyg) {
        this.StudentID = StudentID;
        this.MomentID = MomentID;
        this.BetygID = BetygID;

        super.setGrade(betyg.toString());

    }

    public String getGrade() {
        return super.getGrade();
    }

}
