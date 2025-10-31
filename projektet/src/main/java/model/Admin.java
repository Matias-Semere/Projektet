package model;

public class Admin {
    private int adminID;
    private int userID;
    private String namn;

    public Admin(int adminID, int userID, String namn) {
        this.adminID = adminID;
        this.userID = userID;
        this.namn = namn;
    }

    public int getAdminID() { return adminID; }
    public int getUserID() { return userID; }
    public String getNamn() { return namn; }
    
    
    public void setAdminID(int adminID) { this.adminID = adminID; }
    public void setUserID(int userID) { this.userID = userID; }
    public void setNamn(String namn) { this.namn = namn; }

    @Override
    public String toString() {
        return String.format("AdminID: %d, UserID: %d, Namn: %s",
                adminID, userID, namn);
    }
}
