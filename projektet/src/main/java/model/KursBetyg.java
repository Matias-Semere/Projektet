package model;

public class KursBetyg extends Betyg {

    public enum kBetyg {
        A, B, C, D, E, F;
    }

    public KursBetyg(int StudentID, int BetygID, int KurstillfälleID, kBetyg betyg) {
        this.StudentID = StudentID;
        this.BetygID = BetygID;
        this.KurstillfälleID = KurstillfälleID;

        super.setGrade(betyg.toString());

    }

    public String getGrade() {
        return super.getGrade();
    }

}
