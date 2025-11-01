package dao;

import model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KursSchemaDAO extends BaseDAO<KursSchema> {

    @Override
    protected String getTableName() {
        return "KursSchema";
    }

    @Override
    protected String getInsertColumns() {
        return "KurstillfälleID, Datum, Starttid, Sluttid, Lokal";
    }

    @Override
    protected String getSelectColumns() {
        return "SchemaID, KurstillfälleID, Datum, Starttid, Sluttid, Lokal";
    }

    @Override
    protected String getPrimaryKey() {
        return "SchemaID";
    }

    @Override
    protected void setParameters(PreparedStatement ps, KursSchema entity) throws SQLException {
        ps.setInt(1, entity.getKurstillfälleId());
        ps.setString(2, entity.getDatum());
        ps.setString(3, entity.getStarttid());
        ps.setString(4, entity.getSluttid());
        ps.setString(5, entity.getLokal());
    }

    @Override
    protected void setGeneratedId(KursSchema entity, int id) {
        entity.setID(id);
    }

    @Override
    protected KursSchema mapResultSetToEntity(ResultSet rs) throws SQLException {
        KursSchema ks = new KursSchema(
                rs.getInt("KurstillfälleID"),
                rs.getString("Datum"),
                rs.getString("Starttid"),
                rs.getString("Sluttid"),
                rs.getString("Lokal"));
        ks.setID(rs.getInt("SchemaID"));
        return ks;
    }

    public List<KursSchema> getByKurstillfälleID(int kurstillfälleID) throws SQLException {
        List<KursSchema> list = new ArrayList<>();
        String sql = "SELECT " + getSelectColumns() + " FROM " + getTableName() + " WHERE KurstillfälleID = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, kurstillfälleID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapResultSetToEntity(rs));
            }
        }
        return list;
    }
}
