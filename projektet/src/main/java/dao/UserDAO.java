package dao;

import model.*;
import java.sql.*;

public class UserDAO extends BaseDAO<User> {

    @Override
    protected String getTableName() { return "User"; }

    @Override
    protected String getInsertColumns() { return "Username, Password, Role"; }

    @Override
    protected String getSelectColumns() { return "UserID, Username, Password, Role"; }

    @Override
    protected String getPrimaryKey() { return "UserID"; }

    @Override
    protected void setParameters(PreparedStatement ps, User entity) throws SQLException {
        ps.setString(1, entity.getUsername());
        ps.setString(2, entity.getPassword());
        ps.setString(3, entity.getRole());
    }
    
    @Override
    protected void setGeneratedId(User entity, int id) {
        entity.setID(id);
    }

    @Override
    protected User mapResultSetToEntity(ResultSet rs) throws SQLException {
        User user = new User(rs.getString("Username"), rs.getString("Password"), rs.getString("Role"));
        user.setID(rs.getInt("UserID"));
        return user;
    }

    public User getByUsername(String username) {
    String sql = "SELECT " + getSelectColumns() + " FROM " + getTableName() + " WHERE Username = ?";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return mapResultSetToEntity(rs);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null; // User not found
}

}
