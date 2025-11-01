package dao;

import java.sql.*;
import java.util.*;
import model.*;

public abstract class BaseDAO<T extends BaseModel> {
    protected Connection conn = DataBase.getConnection();

    protected abstract String getTableName();

    protected abstract String getInsertColumns();

    protected abstract String getSelectColumns();

    protected abstract String getPrimaryKey();

    protected abstract void setGeneratedId(T entity, int id);
    
    protected abstract void setParameters(PreparedStatement ps, T entity) throws SQLException;

    protected abstract T mapResultSetToEntity(ResultSet rs) throws SQLException;

    // protected abstract String getWhereClause();

    public T insert(T entity) {
        String sql = "INSERT INTO " + getTableName() + " (" + getInsertColumns() + ") VALUES (" +
                getInsertPlaceholders(getInsertColumns()) + ")";

        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            setParameters(ps, entity);
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    setGeneratedId(entity, rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    public List<T> getAll() {
        List<T> entities = new ArrayList<>();
        String sql = "SELECT * FROM " + getTableName();

        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                T entity = mapResultSetToEntity(rs);
                entities.add(entity);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }

    public void delete(T entity) {
        String sql = "DELETE FROM " + getTableName() + " WHERE " + getPrimaryKey() + " = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, entity.getID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(T entity) {
        // Build SQL dynamically based on insert columns
        String[] columns = getInsertColumns().split(",\\s*"); // Split by comma + optional space
        StringBuilder setClause = new StringBuilder();

        for (int i = 0; i < columns.length; i++) {
            setClause.append(columns[i]).append(" = ?");
            if (i < columns.length - 1)
                setClause.append(", ");
        }

        String sql = "UPDATE " + getTableName() + " SET " + setClause + " WHERE " + getPrimaryKey() + " = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            // Let the DAO fill the parameters for update
            setParameters(ps, entity);
            // Set the ID as the last parameter
            ps.setInt(columns.length + 1, entity.getID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public T getById(int id) {
        String sql = "SELECT " + getSelectColumns() + " FROM " + getTableName() +
                " WHERE " + getPrimaryKey() + " = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapResultSetToEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getInsertPlaceholders(String columns) {
        int count = columns.split(",").length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            if (i > 0)
                sb.append(",");
            sb.append("?");
        }
        return sb.toString();
    }

}