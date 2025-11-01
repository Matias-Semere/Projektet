package model;

public class Registrering extends BaseModel {
    private int studentID;
    private int kurstillfälleID;

    public Registrering(int studentID, int kurstillfälleID) {
        this.studentID = studentID;
        this.kurstillfälleID = kurstillfälleID;
    }

    public int getStudentID() { return studentID; }
    public void setStudentID(int studentID) { this.studentID = studentID; }

    public int getKurstillfälleID() { return kurstillfälleID; }
    public void setKurstillfälleID(int kurstillfälleID) { this.kurstillfälleID = kurstillfälleID; }

    @Override
    public String toString() {
        return String.format("StudentID: %d, KurstillfälleID: %d", studentID, kurstillfälleID);
    }
}
