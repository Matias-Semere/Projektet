package model;

public class Kurstillfälle extends BaseModel {
    private int kursID;
    private String datum;
    private double studietakt;
    private int antalPlatser;

    public Kurstillfälle(int kursID, String datum, double studietakt, int antalPlatser) {
        this.kursID = kursID;
        this.datum = datum;
        this.studietakt = studietakt;
        this.antalPlatser = antalPlatser;
    }

    // Getters and setters
    public int getKursID() { return kursID; }
    public void setKursID(int kursID) { this.kursID = kursID; }

    public String getDatum() { return datum; }
    public void setDatum(String datum) { this.datum = datum; }

    public double getStudietakt() { return studietakt; }
    public void setStudietakt(double studietakt) { this.studietakt = studietakt; }

    public int getAntalPlatser() { return antalPlatser; }
    public void setAntalPlatser(int antalPlatser) { this.antalPlatser = antalPlatser; }

    @Override
    public String toString() {
        return "KursID: " + kursID + " | Datum: " + datum + " | " +
               "Studietakt: " + studietakt + " | Platser: " + antalPlatser;
    }
}
