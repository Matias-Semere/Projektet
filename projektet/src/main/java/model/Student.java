package model;

public class Student extends BaseModel {
    private int userId;
    private String namn;
    private String personnummer;

    public Student(int userId, String namn, String personnummer) {
        this.userId = userId;
        this.namn = namn;
        this.personnummer = personnummer;
    }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getNamn() { return namn; }
    public void setNamn(String namn) { this.namn = namn; }

    public String getPersonnummer() { return personnummer; }
    public void setPersonnummer(String personnummer) { this.personnummer = personnummer; }

    @Override
    public String toString() {
        return String.format("StudentID: %d, UserID: %d, Namn: %s, Personnummer: %s", id, userId, namn, personnummer);
    }
}
