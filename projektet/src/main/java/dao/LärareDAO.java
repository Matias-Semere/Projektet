package dao;

import model.*;
import java.sql.*;

public class LärareDAO extends BaseDAO<Lärare> {

    @Override
    protected String getTableName() {
        return "Lärare";
    }

    @Override
    protected String getInsertColumns() {
        return "UserID, Namn";
    }

    @Override
    protected String getSelectColumns() {
        return "LärareID, UserID, Namn";
    }

    @Override
    protected String getPrimaryKey() {
        return "LärareID";
    }

    @Override
    protected void setParameters(PreparedStatement ps, Lärare entity) throws SQLException {
        ps.setInt(1, entity.getUserId());
        ps.setString(2, entity.getNamn());
    }

    @Override
    protected void setGeneratedId(Lärare entity, int id) {
        entity.setID(id);
    }

    @Override
    protected Lärare mapResultSetToEntity(ResultSet rs) throws SQLException {
        Lärare lärare = new Lärare(rs.getInt("UserID"), rs.getString("Namn"));
        lärare.setID(rs.getInt("LärareID"));
        return lärare;
    }

    public Lärare getByName(String namn) {
        String sql = "SELECT " + getSelectColumns() + " FROM " + getTableName() + " WHERE Namn = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, namn);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapResultSetToEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
