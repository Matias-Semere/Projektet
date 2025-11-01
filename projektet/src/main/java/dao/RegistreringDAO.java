package dao;

import model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegistreringDAO extends BaseDAO<Registrering> {

    @Override
    protected String getTableName() { return "Registrering"; }

    @Override
    protected String getInsertColumns() { return "StudentID, KurstillfälleID"; }

    @Override
    protected String getSelectColumns() { return "StudentID, KurstillfälleID"; }

    @Override
    protected String getPrimaryKey() { 
        return "StudentID, KurstillfälleID"; 
    }

    @Override
    protected void setParameters(PreparedStatement ps, Registrering entity) throws SQLException {
        ps.setInt(1, entity.getStudentID());
        ps.setInt(2, entity.getKurstillfälleID());
    }
    

    @Override
    protected void setGeneratedId(Registrering entity, int id) {
        // Composite primary key, nothing to set
    }

    @Override
    protected Registrering mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new Registrering(rs.getInt("StudentID"), rs.getInt("KurstillfälleID"));
    }

    public List<Registrering> getByStudentID(int studentID) throws SQLException {
        List<Registrering> list = new ArrayList<>();
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
