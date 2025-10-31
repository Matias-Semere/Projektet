package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Kurs;

public class KursDAO {

    public List<Kurs> getAllKurs() {
        List<Kurs> kursList = new ArrayList<>();
        String sql = "SELECT * FROM Kurs";

        try (Connection conn = DataBase.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Kurs kurs = new Kurs(
                        rs.getInt("KursID"),
                        rs.getString("Namn"),
                        rs.getDouble("Studietakt"),
                        rs.getString("Ort"),
                        rs.getInt("Antal_platser"),
                        rs.getString("Kurskod"),
                        rs.getDouble("Högskolepoäng")
                );
                kursList.add(kurs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kursList;
    }

    public void insertKurs(Kurs k) {
        String sql = "INSERT INTO Kurs (KursID, Namn, Studietakt, Ort, Antal_platser, Kurskod, Högskolepoäng) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DataBase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, k.getKursID());
            ps.setString(2, k.getNamn());
            ps.setDouble(3, k.getStudietakt());
            ps.setString(4, k.getOrt());
            ps.setInt(5, k.getAntalPlatser());
            ps.setString(6, k.getKurskod());
            ps.setDouble(7, k.getHögskolepoäng());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteKurs(int kursID) {
        String sql = "DELETE FROM Kurs WHERE KursID = ?";

        try (Connection conn = DataBase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, kursID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateKurs(Kurs k) {
        String sql = "UPDATE Kurs SET Namn = ?, Studietakt = ?, Ort = ?, Antal_platser = ?, Kurskod = ?, Högskolepoäng = ? WHERE KursID = ?";

        try (Connection conn = DataBase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, k.getNamn());
            ps.setDouble(2, k.getStudietakt());
            ps.setString(3, k.getOrt());
            ps.setInt(4, k.getAntalPlatser());
            ps.setString(5, k.getKurskod());
            ps.setDouble(6, k.getHögskolepoäng());
            ps.setInt(7, k.getKursID());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
