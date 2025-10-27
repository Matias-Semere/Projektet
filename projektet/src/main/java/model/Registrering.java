package model;

public class Registrering {
    private int StudentID;
    private String KurstillfälleID;

    public Registrering(int StudentID, String KurstillfälleID) {
        this.StudentID = StudentID;
        this.KurstillfälleID = KurstillfälleID;
<<<<<<< HEAD

    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
=======
>>>>>>> bb0d9e788dd70ddba5ae402d6416ef91f533a8cc
    }

    public int getStudentID() {
        return StudentID;
    }

<<<<<<< HEAD
    public void setKurstillfälleID(String KurstillfälleID) {
        this.KurstillfälleID = KurstillfälleID;
=======
    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
>>>>>>> bb0d9e788dd70ddba5ae402d6416ef91f533a8cc
    }

    public String getKurstillfälleID() {
        return KurstillfälleID;
    }

<<<<<<< HEAD
=======
    public void setKurstillfälleID(String KurstillfälleID) {
        this.KurstillfälleID = KurstillfälleID;
    }

    @Override
    public String toString() {
        return String.format("StudentID: %d, KurstillfälleID: %s",
                StudentID, KurstillfälleID);
    }
>>>>>>> bb0d9e788dd70ddba5ae402d6416ef91f533a8cc
}
