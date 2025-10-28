package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Kurs;

public class KursDAO {

    public List<Kurs> getAllKurs() {
        List<Kurs> kursList = new ArrayList<>();
        try (Statement stmt = DataBase.getConnection().createStatement()) {
            String sql = "SELECT * FROM Kurs";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Kurs kurs = new Kurs(rs.getInt("KursID"), rs.getString("Namn"), rs.getDouble("Studietakt"),
                        rs.getString("Ort"), rs.getInt("Studieplatser"), rs.getString("Kurskod"),
                        rs.getDouble("Hogskolepoang"));
                kursList.add(kurs);
                System.out.println(kurs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return kursList;
    }

    public void insertKurs(Kurs k) {
        String sql = "INSERT INTO Kurs VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setInt(1, k.getKursID());
            ps.setString(2, k.getNamn());
            ps.setDouble(3, k.getStudietäkt());
            ps.setString(4, k.getOrt());
            ps.setInt(5, k.getStudieplatser());
            ps.setString(6, k.getKurskod());
            ps.setDouble(7, k.getHögskolepoäng());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteKurs(Kurs k) {
        String sql = "DELETE FROM Kurs WHERE KursID = ?";

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setInt(1, k.getKursID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void alterKurs(Kurs k) {
        String sql = "UPDATE Kurs SET Namn = ?, Studietakt = ?, Ort = ?, Studieplatser = ?, Kurskod = ?, Högskolepoäng = ? WHERE KursID = ?";

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setString(1, k.getNamn());
            ps.setDouble(2, k.getStudietäkt());
            ps.setString(3, k.getOrt());
            ps.setInt(4, k.getStudieplatser());
            ps.setString(5, k.getKurskod());
            ps.setDouble(6, k.getHögskolepoäng());
            ps.setInt(7, k.getKursID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
