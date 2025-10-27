package model;

public class Rapportering {
    private int RapporteringsID;
    private int StudentID;
    private String MomentID;
    private int LärarID;
    private int AdminID;

    public Rapportering(int RapporteringsID, int StudentID, String MomentID, int LärarID, int AdminID) {
        this.RapporteringsID = RapporteringsID;
        this.StudentID = StudentID;
        this.MomentID = MomentID;
        this.LärarID = LärarID;
        this.AdminID = AdminID;
    }

    public int getRapporteringsID() {
        return RapporteringsID;
    }

    public void setRapporteringsID(int RapporteringsID) {
        this.RapporteringsID = RapporteringsID;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public String getMomentID() {
        return MomentID;
    }

    public void setMomentID(String MomentID) {
        this.MomentID = MomentID;
    }

    public int getLärarID() {
        return LärarID;
    }

    public void setLärarID(int LärarID) {
        this.LärarID = LärarID;
    }

    public int getAdminID() {
        return AdminID;
    }

    public void setAdminID(int AdminID) {
        this.AdminID = AdminID;
    }

    @Override
    public String toString() {
        return String.format("RapporteringsID: %d, StudentID: %d, MomentID: %s, LärarID: %d, AdminID: %d",
                RapporteringsID, StudentID, MomentID, LärarID, AdminID);
    }
    
}
