package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Kurstillfälle;

public class KurstilfälleDAO {
    
    public List<Kurstillfälle> getAllKurstillfälle() {
        List<Kurstillfälle> kurstillfälle = new ArrayList<>();
        try (Statement stmt = DataBase.getConnection().createStatement()) {
            String sql = "SELECT * FROM Kurstillfalle";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Kurstillfälle k = new Kurstillfälle(rs.getString("Kurstillfalle"), rs.getInt("KursID"), rs.getString("Datum"));
                kurstillfälle.add(k);
                System.out.println(k);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return kurstillfälle;
    }

    public void insertKurstillfälle(Kurstillfälle k) {
        String sql = "INSERT INTO Kurstillfalle VALUES (?, ?, ?)";

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setString(1, k.getKurstillfälleID());
            ps.setInt(2, k.getKursID());
            ps.setString(3, k.getDatum());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteKurstillfälle(Kurstillfälle k) {
        String sql = "DELETE FROM Kurstillfalle WHERE KurstillfalleID = ?";

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setString(1, k.getKurstillfälleID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterKurstillfälle(Kurstillfälle k) {
        String sql = "UPDATE Kurstillfalle SET KursID = ?, Datum = ? WHERE KurstillfalleID = ?";

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setInt(1, k.getKursID());
            ps.setString(2, k.getDatum());
            ps.setString(3, k.getKurstillfälleID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
