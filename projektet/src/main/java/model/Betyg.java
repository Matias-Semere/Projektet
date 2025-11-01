package model;

public class Betyg extends BaseModel {
    private int studentID;
    private int kurstillfälleID;
    private String värde;

    public Betyg(int studentID, int kurstillfälleID, String värde) {
        this.studentID = studentID;
        this.kurstillfälleID = kurstillfälleID;
        this.värde = värde;
    }

    public int getStudentID() { return studentID; }
    public void setStudentID(int studentID) { this.studentID = studentID; }

    public int getKurstillfälleID() { return kurstillfälleID; }
    public void setKurstillfälleID(int kurstillfälleID) { this.kurstillfälleID = kurstillfälleID; }

    public String getVärde() { return värde; }
    public void setVärde(String värde) { this.värde = värde; }

    @Override
    public String toString() {
        return String.format("BetygID: %d, StudentID: %d, KurstillfälleID: %d, Värde: %s", id, studentID, kurstillfälleID, värde);
    }
}
