package dao;

import model.*;
import java.sql.*;

public class KursDAO extends BaseDAO<Kurs> {

    @Override
    protected String getTableName() {
        return "Kurs";
    }

    @Override
    protected String getInsertColumns() {
        return "Namn, Studietakt, Ort, Antal_platser, Kurskod, Högskolepoäng";
    }

    @Override
    protected String getSelectColumns() {
        return "KursID, Namn, Studietakt, Ort, Antal_platser, Kurskod, Högskolepoäng";
    }

    @Override
    protected String getPrimaryKey() {
        return "KursID";
    }

    @Override
    protected void setParameters(PreparedStatement ps, Kurs entity) throws SQLException {
        ps.setString(1, entity.getNamn());
        ps.setDouble(2, entity.getStudietakt());
        ps.setString(3, entity.getOrt());
        ps.setInt(4, entity.getAntalPlatser());
        ps.setString(5, entity.getKurskod());
        ps.setDouble(6, entity.getHögskolepoäng());
    }

    @Override
    protected void setGeneratedId(Kurs entity, int id) {
        entity.setID(id);
    }

    @Override
    protected Kurs mapResultSetToEntity(ResultSet rs) throws SQLException {
        Kurs kurs = new Kurs(
                rs.getString("Namn"),
                rs.getDouble("Studietakt"),
                rs.getString("Ort"),
                rs.getInt("Antal_platser"),
                rs.getString("Kurskod"),
                rs.getDouble("Högskolepoäng"));
        kurs.setID(rs.getInt("KursID"));
        return kurs;
    }
}
