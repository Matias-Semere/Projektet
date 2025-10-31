package dao;

import model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void insertStudent(Student student) {
        String sql = "INSERT INTO Student (UserID, Namn, Personnummer) VALUES (?, ?, ?)";
        
        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, student.getUserId());
            ps.setString(2, student.getNamn());
            ps.setString(3, student.getPersonnummer());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    student.setStudentId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertStudent() {
    }

    public void alterStudent(Student student) {
        String sql = "UPDATE Student SET Namn = ?, Personnummer = ?, UserID = ? WHERE StudentID = ?";

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setString(1, student.getNamn());
            ps.setString(2, student.getPersonnummer());
            ps.setInt(3, student.getUserId());
            ps.setInt(4, student.getStudentId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudentByID(int studentID) {
        String sql = "DELETE FROM Student WHERE StudentID = ?";

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setInt(1, studentID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(Student student) {
        deleteStudentByID(student.getStudentId());
    }

    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM Student";
        List<Student> students = new ArrayList<>();

        try (Statement stmt = DataBase.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("StudentID"),
                        rs.getInt("UserID"),
                        rs.getString("Namn"),
                        rs.getString("Personnummer"));
                students.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public Student getStudentByID(int studentID) {
        String sql = "SELECT * FROM Student WHERE StudentID = ?";

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setInt(1, studentID);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Student(
                            rs.getInt("StudentID"),
                            rs.getInt("UserID"),
                            rs.getString("Namn"),
                            rs.getString("Personnummer"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
