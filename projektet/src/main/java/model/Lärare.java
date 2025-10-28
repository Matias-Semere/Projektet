package model;

public class Lärare {
    private int LärarID;
    private String Namn;
    private int Personnummer;
    private int KurstillfälleID;

    public Lärare(String Namn, int Personnummer, int KurstillfälleID) {
        // this.LärarID = LärarID;
        this.Namn = Namn;
        this.Personnummer = Personnummer;
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

    public int getPersonnummer() {
        return Personnummer;
    }

    public void setPersonnummer(int Personnummer) {
        this.Personnummer = Personnummer;
    }

    public int getKurstillfälleID() {
        return KurstillfälleID;
    }

    public void setKurstillfälleID(int KurstillfälleID) {
        this.KurstillfälleID = KurstillfälleID;
    }

    public String toString() {
        return String.format("LärareID: %d, Name: %s, Personnummer: %d, KurstillfälleID: %s",
                LärarID, Namn, Personnummer, KurstillfälleID);
    }
    
}
