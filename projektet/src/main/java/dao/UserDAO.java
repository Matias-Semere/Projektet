package dao;

import model.User;
import java.sql.*;
import java.util.*;

public class UserDAO {

    public void insertUser(User user) {
        String sql = "INSERT INTO User (UserID, Username, Password, Role) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, user.getUserId());
            ps.setString(2, user.getUsername());
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

    public boolean addUser(String username, String password, String role, String namn, String personnummer) {
        String insertUserSQL = "INSERT INTO User (Username, Password, Role) VALUES (?, ?, ?)";
        String insertStudentSQL = "INSERT INTO Student (UserID, Namn, Personnummer) VALUES (?, ?, ?)";
        String insertTeacherSQL = "INSERT INTO Lärare (UserID, Namn) VALUES (?, ?)";
        String insertAdminSQL = "INSERT INTO Admin (UserID, Namn) VALUES (?, ?)";

        try {
            Connection conn = DataBase.getConnection();
            conn.setAutoCommit(false);

            try (PreparedStatement userStmt = conn.prepareStatement(insertUserSQL, Statement.RETURN_GENERATED_KEYS)) {
                userStmt.setString(1, username);
                userStmt.setString(2, password);
                userStmt.setString(3, role);
                userStmt.executeUpdate();

                ResultSet rs = userStmt.getGeneratedKeys();
                if (rs.next()) {
                    int userID = rs.getInt(1);

                    PreparedStatement roleStmt = null;

                    switch (role) {
                        case "Student":
                            roleStmt = conn.prepareStatement(insertStudentSQL);
                            roleStmt.setInt(1, userID);
                            roleStmt.setString(2, namn);
                            roleStmt.setString(3, personnummer);
                            break;
                        case "Teacher":
                            roleStmt = conn.prepareStatement(insertTeacherSQL);
                            roleStmt.setInt(1, userID);
                            roleStmt.setString(2, namn);
                            break;
                        case "Admin":
                            roleStmt = conn.prepareStatement(insertAdminSQL);
                            roleStmt.setInt(1, userID);
                            roleStmt.setString(2, namn);
                            break;
                    }

                    if (roleStmt != null)
                        roleStmt.executeUpdate();
                }

                conn.commit();
                return true;
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
                return false;
            } finally {
                conn.setAutoCommit(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
