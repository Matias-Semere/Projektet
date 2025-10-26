package dao;

import model.Student;

import java.sql.*;
import java.util.*;

public class StudentDAO {

    public void getConnection() {
        DataBase.getConnection();
    }

    public void insertStudent(Student student) {
        String sql = "INSERT INTO Student VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setInt(1, student.getStudentId());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getPersonalNumber());
            ps.setInt(4, student.getYearGroup());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterStudent(Student student) {
        String sql = "UPDATE Student SET Namn = ?, Personnummer = ?, Arskull = ? WHERE StudentID = ?";

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
                        rs.getString("Namn"),
                        rs.getInt("Personnummer"),
                        rs.getInt("Arskull"));
                students.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
