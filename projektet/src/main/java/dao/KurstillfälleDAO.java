package dao;

import model.Kurstillfälle;
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
        return "KursID, Datum, Studietakt, Antal_platser";
    }

    @Override
    protected String getSelectColumns() {
        return "KurstillfälleID, KursID, Datum, Studietakt, Antal_platser";
    }

    @Override
    protected String getPrimaryKey() {
        return "KurstillfälleID";
    }

    @Override
    protected void setParameters(PreparedStatement ps, Kurstillfälle entity) throws SQLException {
        ps.setInt(1, entity.getKursID());
        ps.setString(2, entity.getDatum());
        ps.setDouble(3, entity.getStudietakt());
        ps.setInt(4, entity.getAntalPlatser());
    }

    @Override
    protected void setGeneratedId(Kurstillfälle entity, int id) {
        entity.setID(id);
    }

    @Override
    protected Kurstillfälle mapResultSetToEntity(ResultSet rs) throws SQLException {
        Kurstillfälle kt = new Kurstillfälle(
                rs.getInt("KursID"),
                rs.getString("Datum"),
                rs.getDouble("Studietakt"),
                rs.getInt("Antal_platser"));
        kt.setID(rs.getInt("KurstillfälleID"));
        return kt;
    }

    public List<String> getAllWithCourseNames() {
        String sql = "SELECT k.Namn, kt.* FROM Kurstillfälle kt " +
                "JOIN Kurs k ON kt.KursID = k.KursID";
        List<String> result = new ArrayList<>();

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                result.add(
                        rs.getString("Namn") + " (" + rs.getString("Datum") +
                                ") - " + rs.getInt("Antal_platser") + " platser");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
