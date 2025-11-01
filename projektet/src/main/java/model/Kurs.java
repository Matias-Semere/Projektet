package model;

public class Kurs extends BaseModel {
    private String namn;
    private String kurskod;
    private double högskolepoäng;

    public Kurs(String namn, String kurskod, double högskolepoäng) {
        this.namn = namn;
        this.kurskod = kurskod;
        this.högskolepoäng = högskolepoäng;
    }

    public String getNamn() { return namn; }
    public void setNamn(String namn) { this.namn = namn; }

    public String getKurskod() { return kurskod; }
    public void setKurskod(String kurskod) { this.kurskod = kurskod; }

    public double getHögskolepoäng() { return högskolepoäng; }
    public void setHögskolepoäng(double högskolepoäng) { this.högskolepoäng = högskolepoäng; }

    @Override
    public String toString() {
        return String.format("KursID: %d, Namn: %s, Kurskod: %s, HP: %.1f", 
            id, namn, kurskod, högskolepoäng);
    }
}
