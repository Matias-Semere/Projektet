package model;

public class Kurs {
    private int kursID;
    private String namn;
    private double studietakt;
    private String ort;
    private int antalPlatser;
    private String kurskod;
    private double högskolepoäng;

    public Kurs(int kursID, String namn, double studietakt, String ort, int antalPlatser, String kurskod, double högskolepoäng) {
        this.kursID = kursID;
        this.namn = namn;
        this.studietakt = studietakt;
        this.ort = ort;
        this.antalPlatser = antalPlatser;
        this.kurskod = kurskod;
        this.högskolepoäng = högskolepoäng;
    }

    public int getKursID() { return kursID; }
    public String getNamn() { return namn; }
    public double getStudietakt() { return studietakt; }
    public String getOrt() { return ort; }
    public int getAntalPlatser() { return antalPlatser; }
    public String getKurskod() { return kurskod; }
    public double getHögskolepoäng() { return högskolepoäng; }
    public int setKursID(int kursID) { this.kursID = kursID; return kursID; }

    public String setNamn(String namn) { this.namn = namn; return namn; }
    public double setStudietakt(double studietakt) { this.studietakt = studietakt; return studietakt; }
    public String setOrt(String ort) { this.ort = ort; return ort; }
    public int setAntalPlatser(int antalPlatser) { this.antalPlatser = antalPlatser; return antalPlatser; }
    public String setKurskod(String kurskod) { this.kurskod = kurskod; return kurskod; }
    public double setHögskolepoäng(double högskolepoäng) { this.högskolepoäng = högskolepoäng; return högskolepoäng; }   
}
