package model;

public class Kurstillfälle {
    private String KurstillfälleID;
    private int KursID;
    private String Datum;

    public Kurstillfälle(String KurstillfälleID, int KursID, String Datum) {
        this.KurstillfälleID = KurstillfälleID;
        this.KursID = KursID;
        this.Datum = Datum;
    }

    public String getKurstillfälleID() {
        return KurstillfälleID;
    }

    public void setKurstillfälleID(String KurstillfälleID) {
        this.KurstillfälleID = KurstillfälleID;
    }

    public int getKursID() {
        return KursID;
    }

    public void setKursID(int KursID) {
        this.KursID = KursID;
    }

    public String getDatum() {
        return Datum;
    }

    public void setDatum(String Datum) {
        this.Datum = Datum;
    }

    @Override
    public String toString() {
        return String.format("KurstillfälleID: %s, KursID: %d, Datum: %s",
                KurstillfälleID, KursID, Datum);
    }
}
