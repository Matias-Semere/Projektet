package model;

public class MomentBetyg {

    public enum mBetyg {
        A, B, C, D, E, F, VG, G, U;
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
