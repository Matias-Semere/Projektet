package model;

public class Kurstillfälle extends BaseModel {
    private int kursID;
    private String datum;

    public Kurstillfälle(int kursID, String datum) {
        this.kursID = kursID;
        this.datum = datum;
    }

    public int getKursID() { return kursID; }
    public void setKursID(int kursID) { this.kursID = kursID; }

    public String getDatum() { return datum; }
    public void setDatum(String datum) { this.datum = datum; }

    @Override
    public String toString() {
        return String.format("KurstillfälleID: %d, KursID: %d, Datum: %s", id, kursID, datum);
    }
}
