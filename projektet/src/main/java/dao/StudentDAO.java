package dao;

import model.Student;
import java.sql.*;
import java.util.*;

public class StudentDAO {
    // Insert a student and set its generated ID
    public void insertStudent(Student student) {
        String sql = "INSERT INTO Student (Namn, Personnummer, Årskull) VALUES (?, ?, ?)";

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, student.getName());
            ps.setInt(2, student.getPersonalNumber());
            ps.setInt(3, student.getYearGroup());

            ps.executeUpdate();

            // Get the auto-generated StudentID
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    student.setStudentId(rs.getInt(1)); // set the generated ID in your object
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update an existing student
    public void alterStudent(Student student) {
        String sql = "UPDATE Student SET Namn = ?, Personnummer = ?, Årskull = ? WHERE StudentID = ?";

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setString(1, student.getName());
            ps.setInt(2, student.getPersonalNumber());
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
                        rs.getString("Namn"),
                        rs.getInt("Personnummer"),
                        rs.getInt("Årskull")
                );
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
                        rs.getString("Namn"),
                        rs.getInt("Personnummer"),
                        rs.getInt("Årskull")
                );
                
                return s;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
