package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Betyg;

public class BetygDAO {
    
    public void insertBetyg(Betyg b) {
        String sql = "INSERT INTO Betyg VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setInt(1, b.getBetygID());
            ps.setInt(2, b.getStudentID());
            ps.setInt(3, b.getKurstillfälleID());
            ps.setString(4, b.getGrade().toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBetyg(Betyg betyg) {
        String sql = "DELETE FROM Betyg WHERE BetygID = ?";

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setInt(1, betyg.getBetygID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterBetyg(Betyg b) {
        String sql = "UPDATE Betyg SET KurstillfälleID = ?, Värde = ?, StudentID = ? WHERE BetygID = ?";
        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setInt(1, b.getKurstillfälleID());
            ps.setString(2, b.getGrade().toString());
            ps.setInt(3, b.getStudentID());
            ps.setInt(4, b.getBetygID());
            ps.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
