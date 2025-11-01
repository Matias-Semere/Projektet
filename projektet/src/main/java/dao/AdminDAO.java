package dao;

import model.*;
import java.sql.*;

public class AdminDAO extends BaseDAO<Admin> {

    @Override
    protected String getTableName() {
        return "Admin";
    }

    @Override
    protected String getInsertColumns() {
        return "UserID, Namn";
    }

    @Override
    protected String getSelectColumns() {
        return "AdminID, UserID, Namn";
    }

    @Override
    protected String getPrimaryKey() {
        return "AdminID";
    }

    @Override
    protected void setParameters(PreparedStatement ps, Admin entity) throws SQLException {
        ps.setInt(1, entity.getUserId());
        ps.setString(2, entity.getNamn());
    }

    @Override
    protected void setGeneratedId(Admin entity, int id) {
        entity.setID(id);
    }

    @Override
    protected Admin mapResultSetToEntity(ResultSet rs) throws SQLException {
        Admin admin = new Admin(rs.getInt("UserID"), rs.getString("Namn"));
        admin.setID(rs.getInt("AdminID"));
        return admin;
    }
}
