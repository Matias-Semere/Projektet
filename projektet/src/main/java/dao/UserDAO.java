package dao;

import model.User;
import java.sql.*;
import java.util.*;

public class UserDAO {
    
    public void insertUser(User user) {
        String sql = "INSERT INTO User (UserID, Username, Password, Role) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, user.getUserId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());
            ps.executeUpdate();

            // Get auto-generated UserID
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    user.setUserId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    
    public void deleteUser(User user) {     
        String sql = "DELETE FROM User WHERE UserID = ?";
        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setInt(1, user.getUserId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM User";
        List<User> users = new ArrayList<>();

        try (Statement stmt = DataBase.getConnection().createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                User u = new User(
                        rs.getInt("UserID"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getString("Role"));
                users.add(u);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return users;
    }


}
