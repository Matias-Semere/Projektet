package model;

public class Moment {
    private String MomentID;
    private String KurstillfälleID;
    private int BetygID;

    public Moment(String MomentID, String KurstillfälleID, int BetygID) {
        this.MomentID = MomentID;
        this.KurstillfälleID = KurstillfälleID;
        this.BetygID = BetygID;

    }

    public void setMomentID(String MomentID) {
        this.MomentID = MomentID;

    }

    public String getMomentID() {
        return MomentID;
    }

    public void setKurstillfälleID(String KurstillfälleID) {
        this.KurstillfälleID = KurstillfälleID;

    }

    public String getKurstillfälleID() {
        return KurstillfälleID;
    }

    public void setBetygID(int BetygID) {
        this.BetygID = BetygID;

    }

    public int getBetygID() {
        return BetygID;
    }

}
