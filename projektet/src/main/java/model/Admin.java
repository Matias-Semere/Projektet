package model;

public class Admin {
    private String Namn;
    private String Epost;
    private int AdminID;
    private String roll;

    public Admin(String Namn, String Epost, int AdminID, String roll) {
        this.Namn = Namn;
        this.Epost = Epost;
        this.AdminID = AdminID;
        this.roll = roll;
    }

    public void setNamn(String Namn) {
        this.Namn = Namn;
    }

    public String getNamn() {
        return Namn;
    }

    public void setEpost(String Epost) {
        this.Epost = Epost;
    }

    public String getEpost() {
        return Epost;
    }

    public void setAdminID(int AdminID) {
        this.AdminID = AdminID;
    }

    public int getAdminID() {
        return AdminID;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getRoll() {
        return roll;
    }

    public String toString() {
        return Namn + " " + Epost + " " + AdminID + " " + roll; 
    }

}
