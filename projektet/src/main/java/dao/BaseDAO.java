package dao;

import java.sql.*;
import java.util.*;

public abstract class BaseDAO<T> {
    protected Connection conn = DataBase.getConnection();

    protected abstract String getTableName();

    protected abstract String getInsertColumns();

    protected abstract String getSelectColumns();

    protected abstract T mapResultSetToEntity(ResultSet rs) throws SQLException;

    public T insert(T entity) {
        String sql = "INSERT INTO " + getTableName() + " (" + getInsertColumns() + ") VALUES (" +
                getInsertPlaceholders(getInsertColumns()) + ")";

        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            setInsertParameters(ps, entity);
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
            ps.setInt(1, entity.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected abstract void setInsertParameters(PreparedStatement ps, T entity) throws SQLException;

    protected abstract void setGeneratedId(T entity, int id);

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