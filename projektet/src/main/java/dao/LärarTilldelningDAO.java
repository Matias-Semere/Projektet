package dao;

import model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LärarTilldelningDAO extends BaseDAO<LärarTilldelning> {

    @Override
    protected String getTableName() {
        return "LärarTilldelning";
    }

    @Override
    protected String getInsertColumns() {
        return "LärareID, KurstillfälleID";
    }

    @Override
    protected String getSelectColumns() {
        return "TilldelningID, LärareID, KurstillfälleID";
    }

    @Override
    protected String getPrimaryKey() {
        return "TilldelningID";
    }

    @Override
    protected void setParameters(PreparedStatement ps, LärarTilldelning entity) throws SQLException {
        ps.setInt(1, entity.getLärareId());
        ps.setInt(2, entity.getKurstillfälleId());
    }

    @Override
    protected void setGeneratedId(LärarTilldelning entity, int id) {
        entity.setID(id);
    }

    @Override
    protected LärarTilldelning mapResultSetToEntity(ResultSet rs) throws SQLException {
        LärarTilldelning lt = new LärarTilldelning(
            rs.getInt("LärareID"),
            rs.getInt("KurstillfälleID")
        );
        lt.setID(rs.getInt("TilldelningID"));
        return lt;
    }

    public List<LärarTilldelning> getByLärareID(int lärareID) throws SQLException {
        List<LärarTilldelning> list = new ArrayList<>();
        String sql = "SELECT " + getSelectColumns() + " FROM " + getTableName() + " WHERE LärareID = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, lärareID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapResultSetToEntity(rs));
            }
        }
        return list;
    }

    public void deleteByLärareAndKurstillfälle(int lärareID, int kurstillfälleID) {
        String sql = "DELETE FROM " + getTableName() + " WHERE LärareID = ? AND KurstillfälleID = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, lärareID);
            ps.setInt(2, kurstillfälleID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
