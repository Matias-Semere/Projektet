package model;

public class Lärare {
    private int LärarID;
    private String Namn;
    private int KurstillfälleID;

    public Lärare(int LärarID, String Namn, int KurstillfälleID) {
        this.LärarID = LärarID;
        this.Namn = Namn;
        this.KurstillfälleID = KurstillfälleID;
    }

    public int getLärarID() {
        return LärarID;
    }

    public void setLärarID(int LärarID) {
        this.LärarID = LärarID;
    }

    public String getNamn() {
        return Namn;
    }

    public void setNamn(String Namn) {
        this.Namn = Namn;
    }

    public int getKurstillfälleID() {
        return KurstillfälleID;
    }

    public void setKurstillfälleID(int KurstillfälleID) {
        this.KurstillfälleID = KurstillfälleID;
    }

    public String toString() {
        return String.format("LärareID: %d, Name: %s, KurstillfälleID: %s",
                LärarID, Namn, KurstillfälleID);
    }
    
}
