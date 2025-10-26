package dao;

import model.Student;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private static final String DB_PATH = System.getProperty("user.dir") + "/student_database.db";
    // private static List<Student> students = new ArrayList<>();

    static {
        try {
            File dbFile = new File(DB_PATH);
            if (!dbFile.exists()) {
                InputStream in = StudentDAO.class.getResourceAsStream("/student_database.db");
                Files.copy(in, dbFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Databasen skapades!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Connection connect() throws SQLException {
        String url = "jdbc:sqlite:" + DB_PATH;
        return DriverManager.getConnection(url);
    }

    public void insertStudent(Student student) {
        String sql = "INSERT INTO Student VALUES (?, ?, ?, ?)";

        try (Connection conn = connect();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, student.getStudentId());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getPersonalNumber());
            ps.setInt(4, student.getYearGroup());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudentByID(int studentID) {
        String sql = "DELETE FROM Student WHERE StudentID = ?";
        
        try (Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
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
        try (Connection conn = connect();
                Statement stmt = conn.createStatement();
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
