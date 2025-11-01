package dao;

import java.sql.*;
import java.util.*;
import model.Kurstillfälle;

public class KurstilfälleDAO {
    Connection conn = DataBase.getConnection();

    public Kurstillfälle getKurstillfälle(String kurstillfälleID) {
        Kurstillfälle k = null;
        try (Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM Kurstillfälle WHERE KurstillfälleID = ?";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                k = new Kurstillfälle(rs.getInt("KurstillfälleID"), rs.getInt("KursID"), rs.getString("Datum"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return k;
    }
    
    public List<Kurstillfälle> getAllKurstillfälle() {
        List<Kurstillfälle> kurstillfälle = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM Kurstillfälle";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Kurstillfälle k = new Kurstillfälle(rs.getInt("KurstillfälleID"), rs.getInt("KursID"), rs.getString("Datum"));
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
        String sql = "INSERT INTO Kurstillfälle VALUES (?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, k.getKurstillfälleID());
            ps.setInt(2, k.getKursID());
            ps.setString(3, k.getDatum());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteKurstillfälle(Kurstillfälle k) {
        String sql = "DELETE FROM Kurstillfälle WHERE KurstillfälleID = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, k.getKurstillfälleID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterKurstillfälle(Kurstillfälle k) {
        String sql = "UPDATE Kurstillfälle SET KursID = ?, Datum = ? WHERE KurstillfälleID = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, k.getKursID());
            ps.setString(2, k.getDatum());
            ps.setInt(3, k.getKurstillfälleID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
