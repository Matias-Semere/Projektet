package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Statement;

import model.Admin;

public class AdminDAO {

    public List<Admin> getAllAdmins() {
        List<Admin> adminList = new ArrayList<>();

        try (Statement stmt = DataBase.getConnection().createStatement()) {
            String sql = "SELECT * FROM Admin";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Admin a = new Admin(rs.getString("Namn"), rs.getString("Epost"), rs.getInt("AdminID"),
                        rs.getString("roll"));
                adminList.add(a);
                System.out.println(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminList;
    }

    public void insertLärare(Admin admin) {
        String sql = "INSERT INTO Admin VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setString(1, admin.getNamn());
            ps.setString(2, admin.getEpost());
            ps.setInt(3, admin.getAdminID());
            ps.setString(4, admin.getRoll());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAdmin(Admin admin) {
        String sql = "DELETE FROM Admin WHERE AdminID =  ?";

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setInt(1, admin.getAdminID());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterAdmin(Admin admin) {
        String sql = "UPDATE Admin SET Namn = ?, Epost = ?, AdminID = ?, roll = ?, WHERE AdminID = ?";

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setString(1, admin.getNamn());
            ps.setString(2, admin.getEpost());
            ps.setInt(3, admin.getAdminID());
            ps.setString(4, admin.getRoll());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
