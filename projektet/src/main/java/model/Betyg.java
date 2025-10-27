package model;

public class Betyg {
    protected int BetygID;
    protected int StudentID;
    protected int MomentID;
    protected int KurstillfälleID;

    private String betyg;

    public Betyg() {
    }

    public void setGrade(String s) {
        this.betyg = s;
    }

    public String getGrade() {
        return betyg;
    }

}
