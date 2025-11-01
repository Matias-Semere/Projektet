package dao;

import model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RapporteringDAO extends BaseDAO<Rapportering> {

    @Override
    protected String getTableName() {
        return "Rapportering";
    }

    @Override
    protected String getInsertColumns() {
        return "StudentID, KurstillfälleID, LärareID, AdminID";
    }

    @Override
    protected String getSelectColumns() {
        return "RapporteringID, StudentID, KurstillfälleID, LärareID, AdminID";
    }

    @Override
    protected String getPrimaryKey() {
        return "RapporteringID";
    }

    @Override
    protected void setParameters(PreparedStatement ps, Rapportering entity) throws SQLException {
        ps.setInt(1, entity.getStudentID());
        ps.setInt(2, entity.getKurstillfälleID());
        ps.setInt(3, entity.getLärareID());
        ps.setInt(4, entity.getAdminID());
    }

    @Override
    protected void setGeneratedId(Rapportering entity, int id) {
        entity.setID(id);
    }

    @Override
    protected Rapportering mapResultSetToEntity(ResultSet rs) throws SQLException {
        Rapportering r = new Rapportering(
                rs.getInt("StudentID"),
                rs.getInt("KurstillfälleID"),
                rs.getInt("LärareID"),
                rs.getInt("AdminID"));
        r.setID(rs.getInt("RapporteringID"));
        return r;
    }

    // Custom methods
    public List<Rapportering> getByStudentID(int studentID) throws SQLException {
        List<Rapportering> list = new ArrayList<>();
        String sql = "SELECT " + getSelectColumns() + " FROM " + getTableName() + " WHERE StudentID = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, studentID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapResultSetToEntity(rs));
            }
        }
        return list;
    }
}
