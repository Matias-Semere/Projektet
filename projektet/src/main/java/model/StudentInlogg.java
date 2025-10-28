package model;

public class StudentInlogg {
    
    int studentID;
    String lösenord;

    public StudentInlogg(int studentID, String lösenord) {
        this.studentID = studentID;
        this.lösenord = lösenord;
    }
        
    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getlösenord() {
        return lösenord;
    }

    public void setlösenord(String lösenord) {
        this.lösenord = lösenord;
    }

}
