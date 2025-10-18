package dao;

import model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private static final String DB_PATH = "projektet/src/main/resources/student_database.db";

    // public static void main(String[] args) throws SQLException {
    //     StudentDAO sd = new StudentDAO();
    //     sd.connect(); 
    // }


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

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Student";

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
