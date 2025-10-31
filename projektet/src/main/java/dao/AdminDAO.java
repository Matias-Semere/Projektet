package dao;

import model.Admin;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {

    // Get all admins from the Admin table
    public List<Admin> getAllAdmins() {
        List<Admin> adminList = new ArrayList<>();
        String sql = "SELECT * FROM Admin";

        try (Statement stmt = DataBase.getConnection().createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                // Fetch the Admin details
                Admin admin = new Admin(
                        rs.getInt("AdminID"),
                        rs.getInt("UserID"),
                        rs.getString("Namn")
                );
                adminList.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminList;
    }

    // Insert Admin into the Admin table (assuming User already exists)
    public void insertAdmin(Admin admin) {
        String sql = "INSERT INTO Admin (UserID, Namn) VALUES (?, ?)";

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            // Insert Admin linked to a User by UserID
            ps.setInt(1, admin.getUserID());  // UserID is assumed to exist already
            ps.setString(2, admin.getNamn()); // Admin's name
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete an admin by AdminID (cascades to User because of foreign key)
    public void deleteAdmin(Admin admin) {
        String sql = "DELETE FROM Admin WHERE AdminID = ?";

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setInt(1, admin.getAdminID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update Admin details (e.g., Admin's name)
    public void alterAdmin(Admin admin) {
        String sql = "UPDATE Admin SET Namn = ? WHERE AdminID = ?";

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setString(1, admin.getNamn());  // Update name
            ps.setInt(2, admin.getAdminID());  // Find by AdminID
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get Admin by AdminID
    public Admin getAdminByID(int adminID) {
        Admin admin = null;
        String sql = "SELECT * FROM Admin WHERE AdminID = ?";

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setInt(1, adminID);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Retrieve the Admin from the database
                    admin = new Admin(
                            rs.getInt("AdminID"),
                            rs.getInt("UserID"),
                            rs.getString("Namn")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
}
