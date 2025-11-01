package model;

public class Kurs extends BaseModel {
    private String namn;
    private double studietakt;
    private String ort;
    private int antalPlatser;
    private String kurskod;
    private double högskolepoäng;

    public Kurs(String namn, double studietakt, String ort, int antalPlatser, String kurskod, double högskolepoäng) {
        this.namn = namn;
        this.studietakt = studietakt;
        this.ort = ort;
        this.antalPlatser = antalPlatser;
        this.kurskod = kurskod;
        this.högskolepoäng = högskolepoäng;
    }

    public String getNamn() { return namn; }
    public void setNamn(String namn) { this.namn = namn; }

    public double getStudietakt() { return studietakt; }
    public void setStudietakt(double studietakt) { this.studietakt = studietakt; }

    public String getOrt() { return ort; }
    public void setOrt(String ort) { this.ort = ort; }

    public int getAntalPlatser() { return antalPlatser; }
    public void setAntalPlatser(int antalPlatser) { this.antalPlatser = antalPlatser; }

    public String getKurskod() { return kurskod; }
    public void setKurskod(String kurskod) { this.kurskod = kurskod; }

    public double getHögskolepoäng() { return högskolepoäng; }
    public void setHögskolepoäng(double högskolepoäng) { this.högskolepoäng = högskolepoäng; }

    @Override
    public String toString() {
        return String.format("KursID: %d, Namn: %s, Ort: %s, Studietakt: %.1f, Platser: %d, Kurskod: %s, HP: %.1f",
                id, namn, ort, studietakt, antalPlatser, kurskod, högskolepoäng);
    }
}
