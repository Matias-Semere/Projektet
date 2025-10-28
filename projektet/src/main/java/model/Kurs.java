package model;

public class Kurs {
    private int KursID;
    private String Namn;
    private double Studietakt;
    private String Ort;
    private int Antal_platser;
    private String Kurskod;
    private double Högskolepoäng;

    public Kurs(int KursID, String Namn, double Studietakt, String Ort, int Antal_platser, String Kurskod, double Högskolepoäng) {
        this.KursID = KursID;
        this.Namn = Namn;
        this.Studietakt = Studietakt;
        this.Ort = Ort;
        this.Antal_platser = Antal_platser;
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
        return Antal_platser;
    }

    public void setStudieplatser(int Antal_platser) {
        this.Antal_platser = Antal_platser;
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
        return String.format("KursID: %d, Namn: %s, Studietakt: %.2f, Ort: %s, Antal_platser: %d, Kurskod: %s, Högskolepoäng: %.2f",
                KursID, Namn, Studietakt, Ort, Antal_platser, Kurskod, Högskolepoäng);
    }
}
