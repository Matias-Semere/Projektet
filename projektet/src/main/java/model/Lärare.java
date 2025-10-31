package model;

public class Lärare {
    private int lärareID;
    private int userID;
    private String namn;

    public Lärare(int lärareID, int userID, String namn) {
        this.lärareID = lärareID;
        this.userID = userID;
        this.namn = namn;
    }

    public int getLärareID() { return lärareID; }
    public int getUserID() { return userID; }
    public String getNamn() { return namn; }
    
    public void setLärareID(int lärareID) { this.lärareID = lärareID; }
    public void setUserID(int userID) { this.userID = userID; }
    public void setNamn(String namn) { this.namn = namn; }

    @Override
    public String toString() {
        return String.format("LärareID: %d, UserID: %d, Namn: %s",
                lärareID, userID, namn);
    }
}
