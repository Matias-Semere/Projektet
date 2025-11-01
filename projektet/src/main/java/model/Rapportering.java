package model;

public class Rapportering extends BaseModel {
    private int studentID;
    private int kurstillfälleID;
    private int lärareID;
    private int adminID;

    public Rapportering(int studentID, int kurstillfälleID, int lärareID, int adminID) {
        this.studentID = studentID;
        this.kurstillfälleID = kurstillfälleID;
        this.lärareID = lärareID;
        this.adminID = adminID;
    }

    public int getStudentID() { return studentID; }
    public void setStudentID(int studentID) { this.studentID = studentID; }

    public int getKurstillfälleID() { return kurstillfälleID; }
    public void setKurstillfälleID(int kurstillfälleID) { this.kurstillfälleID = kurstillfälleID; }

    public int getLärareID() { return lärareID; }
    public void setLärareID(int lärareID) { this.lärareID = lärareID; }

    public int getAdminID() { return adminID; }
    public void setAdminID(int adminID) { this.adminID = adminID; }

    @Override
    public String toString() {
        return String.format("RapporteringID: %d, StudentID: %d, KurstillfälleID: %d, LärareID: %d, AdminID: %d",
                id, studentID, kurstillfälleID, lärareID, adminID);
    }
}
