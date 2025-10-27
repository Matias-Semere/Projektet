package model;

public class Kurs {
    private int KursID;
    private String Namn;
    private double Studietakt;
    private String Ort;
    private int Studieplatser;
    private String Kurskod;
    private double Högskolepoäng;

    public Kurs(int KursID, String Namn, double Studietakt, String Ort, int Studieplatser, String Kurskod, double Högskolepoäng) {
        this.KursID = KursID;
        this.Namn = Namn;
        this.Studietakt = Studietakt;
        this.Ort = Ort;
        this.Studieplatser = Studieplatser;
        this.Kurskod = Kurskod;
        this.Högskolepoäng = Högskolepoäng;
    }

    public int getKursID() {
        return KursID;
    }

    public void setKursID(int KursID) {
        this.KursID = KursID;
    }

    public String getNamn() {
        return Namn;
    }

    public void setNamn(String Namn) {
        this.Namn = Namn;
    }

    public double getStudietäkt() {
        return Studietakt;
    }

    public void setStudietäkt(double Studietakt) {
        this.Studietakt = Studietakt;
    }

    public String getOrt() {
        return Ort;
    }

    public void setOrt(String Ort) {
        this.Ort = Ort;
    }

    public int getStudieplatser() {
        return Studieplatser;
    }

    public void setStudieplatser(int Studieplatser) {
        this.Studieplatser = Studieplatser;
    }

    public String getKurskod() {
        return Kurskod;
    }

    public void setKurskod(String Kurskod) {
        this.Kurskod = Kurskod;
    }

    public double getHögskolepoäng() {
        return Högskolepoäng;
    }

    public void setHögskolepoäng(double Högskolepoäng) {
        this.Högskolepoäng = Högskolepoäng;
    }

    @Override
    public String toString() {
        return String.format("KursID: %d, Namn: %s, Studietakt: %.2f, Ort: %s, Studieplatser: %d, Kurskod: %s, Högskolepoäng: %.2f",
                KursID, Namn, Studietakt, Ort, Studieplatser, Kurskod, Högskolepoäng);
    }
}
