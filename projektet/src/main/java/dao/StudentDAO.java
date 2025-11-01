package dao;

import model.*;
import java.sql.*;

public class StudentDAO extends BaseDAO<Student> {
    @Override
    protected String getTableName() {
        return "Student";
    }

    @Override
    protected String getInsertColumns() {
        return "UserID, Namn, Personnummer";
    }

    @Override
    protected String getSelectColumns() {
        return "StudentID, UserID, Namn, Personnummer";
    }

    @Override
    protected String getPrimaryKey() {
        return "StudentID";
    }

    @Override
    protected void setParameters(PreparedStatement ps, Student entity) throws SQLException {
        ps.setInt(1, entity.getUserId());
        ps.setString(2, entity.getNamn());
        ps.setString(3, entity.getPersonnummer());
    }

    @Override
    protected void setGeneratedId(Student entity, int id) {
        entity.setID(id);
    }

    @Override
    protected Student mapResultSetToEntity(ResultSet rs) throws SQLException {
        Student student = new Student(
                rs.getInt("UserID"),
                rs.getString("Namn"),
                rs.getString("Personnummer"));
        student.setID(rs.getInt("StudentID"));
        return student;
    }

}
