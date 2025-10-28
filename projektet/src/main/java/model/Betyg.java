package model;

public class Betyg {
    private int StudentID;
    private int BetygID;
    private int KurstillfälleID;
    private Grades värde;

    public enum Grades {
        A, B, C, D, E, F, MVG, VG, G, U;
    }

    public Betyg(int StudentID, int KurstillfälleID, Grades värde) {
        setStudentID(StudentID);
        setKurstillfälleID(KurstillfälleID);
        setGrade(värde);
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setKurstillfälleID(int kurstillfälleID) {
        this.KurstillfälleID = kurstillfälleID;
    }

    public int getKurstillfälleID() {
        return KurstillfälleID;
    }

    public void setGrade(Grades grade) {
        this.värde = grade;
    }

    public Grades getGrade() {
        return värde;
    }

    public void setBetygID(int BetygID) {
        this.BetygID = BetygID;
    }

    public int getBetygID() {
        return BetygID;
    }

}
