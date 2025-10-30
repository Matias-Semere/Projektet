package dao;

import model.Student;
import java.sql.*;
import java.util.*;

public class StudentDAO {
    public void insertStudentWithUserID(Student student, int userId) {
        Student studentWithUserId = new Student(student.getStudentId(), userId, student.getName(),
                student.getYearGroup());
        insertStudent(studentWithUserId);
    }

    public void insertStudent(Student student) {
        String sql = "INSERT INTO Student (UserID, Namn, Årskull) VALUES (?, ?, ?)";
        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, student.getUserId()); // Use from student object
            ps.setString(2, student.getName());
            ps.setInt(3, student.getYearGroup());
            ps.executeUpdate();

            // Get auto-generated StudentID
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    student.setStudentId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update an existing student
    public void alterStudent(Student student) {
        String sql = "UPDATE Student SET Namn = ?, UserID = ?, Årskull = ? WHERE StudentID = ?";

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setString(1, student.getName());
            ps.setInt(2, student.getUserId());
            ps.setInt(3, student.getYearGroup());
            ps.setInt(4, student.getStudentId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete by ID
    public void deleteStudentByID(int studentID) {
        String sql = "DELETE FROM Student WHERE StudentID = ?";
        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setInt(1, studentID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete by student object
    public void deleteStudent(Student student) {
        deleteStudentByID(student.getStudentId());
    }

    // Get all students
    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM Student";
        List<Student> students = new ArrayList<>();

        try (Statement stmt = DataBase.getConnection().createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("StudentID"),
                        rs.getInt("UserID"),
                        rs.getString("Name"),
                        rs.getInt("Årskull"));
                s.setStudentId(rs.getInt("StudentID")); // include ID
                students.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public Student getStudentByID(int studentID) {
        String sql = "SELECT * FROM Student WHERE StudentID = ?";
        try (Statement stmt = DataBase.getConnection().createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("StudentID"),
                        rs.getInt("UserID"),
                        rs.getString("Name"),
                        rs.getInt("Årskull"));

                return s;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
