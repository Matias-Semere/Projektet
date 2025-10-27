package model;

public class Registrering {
    private int StudentID;
    private String KurstillfälleID;

    public Registrering(int StudentID, String KurstillfälleID) {
        this.StudentID = StudentID;
        this.KurstillfälleID = KurstillfälleID;

    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setKurstillfälleID(String KurstillfälleID) {
        this.KurstillfälleID = KurstillfälleID;
    }

    public String getKurstillfälleID() {
        return KurstillfälleID;
    }

    @Override
    public String toString() {
        return String.format("StudentID: %d, KurstillfälleID: %s",
                StudentID, KurstillfälleID);
    }
}
