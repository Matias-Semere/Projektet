package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.StudentInlogg;

public class StudentInloggDAO {

    public void insertStudentInlogg(StudentInlogg studentInlogg) {
        String sql = "INSERT INTO StudentInloggning VALUES (?, ?)";

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setInt(1, studentInlogg.getStudentID());
            ps.setString(2, studentInlogg.getlösenord());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudentInlogg(StudentInlogg studentInlogg) {
        String sql = "DELETE FROM StudentInloggning WHERE StudentID = ?";

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setInt(1, studentInlogg.getStudentID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterStudentInlogg(StudentInlogg studentInlogg) {
        String sql = "UPDATE StudentInloggning SET StudentID = ?, Lösenord = ?, WHERE StudentID = ?";
        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setInt(1, studentInlogg.getStudentID());
            ps.setString(2, studentInlogg.getlösenord());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

}
