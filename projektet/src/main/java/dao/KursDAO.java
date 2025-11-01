package dao;

import model.Kurs;
import java.util.*;

import java.sql.*;

public class KursDAO extends BaseDAO<Kurs> {

    @Override
    protected String getTableName() {
        return "Kurs";
    }

    @Override
    protected String getInsertColumns() {
        return "Namn, Kurskod, Högskolepoäng";
    }

    @Override
    protected String getSelectColumns() {
        return "KursID, Namn, Kurskod, Högskolepoäng";
    }

    @Override
    protected String getPrimaryKey() {
        return "KursID";
    }

    @Override
    protected void setParameters(PreparedStatement ps, Kurs entity) throws SQLException {
        ps.setString(1, entity.getNamn());
        ps.setString(2, entity.getKurskod());
        ps.setDouble(3, entity.getHögskolepoäng());
    }

    @Override
    protected void setGeneratedId(Kurs entity, int id) {
        entity.setID(id);
    }

    @Override
    protected Kurs mapResultSetToEntity(ResultSet rs) throws SQLException {
        Kurs kurs = new Kurs(
            rs.getString("Namn"),
            rs.getString("Kurskod"),
            rs.getDouble("Högskolepoäng")
        );
        kurs.setID(rs.getInt("KursID"));
        return kurs;
    }

    public List<Kurs> getByKursID(int kursID) throws SQLException {
        List<Kurs> list = new ArrayList<>();
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
