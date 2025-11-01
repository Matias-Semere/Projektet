package dao;

import model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KurstillfälleDAO extends BaseDAO<Kurstillfälle> {

    @Override
    protected String getTableName() {
        return "Kurstillfälle";
    }

    @Override
    protected String getInsertColumns() {
        return "KursID, Datum";
    }

    @Override
    protected String getSelectColumns() {
        return "KurstillfälleID, KursID, Datum";
    }

    @Override
    protected String getPrimaryKey() {
        return "KurstillfälleID";
    }

    @Override
    protected void setParameters(PreparedStatement ps, Kurstillfälle entity) throws SQLException {
        ps.setInt(1, entity.getKursID());
        ps.setString(2, entity.getDatum());
    }

    @Override
    protected void setGeneratedId(Kurstillfälle entity, int id) {
        entity.setID(id);
    }

    @Override
    protected Kurstillfälle mapResultSetToEntity(ResultSet rs) throws SQLException {
        Kurstillfälle kurstillfälle = new Kurstillfälle(
                rs.getInt("KursID"),
                rs.getString("Datum"));
        kurstillfälle.setID(rs.getInt("KurstillfälleID"));
        return kurstillfälle;
    }

    // Custom method: get all Kurstillfällen for a specific Kurs
    public List<Kurstillfälle> getByKursID(int kursID) throws SQLException {
        List<Kurstillfälle> list = new ArrayList<>();
        String sql = "SELECT " + getSelectColumns() + " FROM " + getTableName() + " WHERE KursID = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, kursID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapResultSetToEntity(rs));
            }
        }
        return list;
    }
}
