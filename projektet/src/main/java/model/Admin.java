package model;

public class Admin extends BaseModel {
    private int userId;
    private String namn;

    public Admin(int userId, String namn) {
        this.userId = userId;
        this.namn = namn;
    }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getNamn() { return namn; }
    public void setNamn(String namn) { this.namn = namn; }

    @Override
    public String toString() {
        return String.format("AdminID: %d, UserID: %d, Namn: %s", id, userId, namn);
    }
}
