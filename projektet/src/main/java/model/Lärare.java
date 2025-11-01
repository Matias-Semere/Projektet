package model;

public class Lärare extends BaseModel {
    private int userId;
    private String namn;

    public Lärare(int userId, String namn) {
        this.userId = userId;
        this.namn = namn;
    }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getNamn() { return namn; }
    public void setNamn(String namn) { this.namn = namn; }

    @Override
    public String toString() {
        return String.format("LärareID: %d, UserID: %d, Namn: %s", id, userId, namn);
    }
}
