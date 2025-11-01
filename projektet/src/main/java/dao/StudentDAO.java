package dao;

import model.*;
import java.sql.*;

public class StudentDAO extends BaseDAO<Student> {
    @Override
    protected String getTableName() { return "Student"; }
    
    @Override
    protected String getInsertColumns() { return "UserID, Namn, Personnummer"; }
    
    @Override
    protected String getSelectColumns() { return "StudentID, UserID, Namn, Personnummer"; }
    
    @Override
    protected void setInsertParameters(PreparedStatement ps, Student entity) throws SQLException {
        ps.setInt(1, entity.getUserId());
        ps.setString(2, entity.getNamn());
        ps.setString(3, entity.getPersonnummer());
    }
    
    @Override
    protected void setGeneratedId(Student entity, int id) {
        entity.setStudentId(id);
    }
    
    @Override
    protected Student mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new Student(
            rs.getInt("StudentID"),
            rs.getInt("UserID"), 
            rs.getString("Namn"),
            rs.getString("Personnummer"));
    }
    
    // Keep your specific methods like alterStudent(), deleteStudentByID()
}
