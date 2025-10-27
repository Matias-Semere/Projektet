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

<<<<<<< HEAD
    public void setRapporteringID(int RapporteringsID) {
        this.RapporteringsID = RapporteringsID;
    }

=======
>>>>>>> bb0d9e788dd70ddba5ae402d6416ef91f533a8cc
    public int getRapporteringsID() {
        return RapporteringsID;
    }

<<<<<<< HEAD
    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
=======
    public void setRapporteringsID(int RapporteringsID) {
        this.RapporteringsID = RapporteringsID;
>>>>>>> bb0d9e788dd70ddba5ae402d6416ef91f533a8cc
    }

    public int getStudentID() {
        return StudentID;
    }

<<<<<<< HEAD
    public void setMomentID(String MomentID) {
        this.MomentID = MomentID;
=======
    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
>>>>>>> bb0d9e788dd70ddba5ae402d6416ef91f533a8cc
    }

    public String getMomentID() {
        return MomentID;
    }

<<<<<<< HEAD
    public void setLärarID(int LärarID) {
        this.LärarID = LärarID;
=======
    public void setMomentID(String MomentID) {
        this.MomentID = MomentID;
>>>>>>> bb0d9e788dd70ddba5ae402d6416ef91f533a8cc
    }

    public int getLärarID() {
        return LärarID;
    }

<<<<<<< HEAD
    public void setAdminID(int AdminID) {
        this.AdminID = AdminID;
=======
    public void setLärarID(int LärarID) {
        this.LärarID = LärarID;
>>>>>>> bb0d9e788dd70ddba5ae402d6416ef91f533a8cc
    }

    public int getAdminID() {
        return AdminID;
    }

<<<<<<< HEAD
=======
    public void setAdminID(int AdminID) {
        this.AdminID = AdminID;
    }

    @Override
    public String toString() {
        return String.format("RapporteringsID: %d, StudentID: %d, MomentID: %s, LärarID: %d, AdminID: %d",
                RapporteringsID, StudentID, MomentID, LärarID, AdminID);
    }
    
>>>>>>> bb0d9e788dd70ddba5ae402d6416ef91f533a8cc
}
