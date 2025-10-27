package dao;

import model.Lärare;
import java.sql.*;
import java.util.*;

public class LärareDAO {
    
    public void getAllLärare() {
        try (Statement stmt = DataBase.getConnection().createStatement()) {
            String sql = "SELECT * FROM Larare";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Lärare l = new Lärare(rs.getInt("LarareID"), rs.getString("Namn"), rs.getInt("Personnummer"), rs.getString("KurstillfalleID"));
                System.out.println(l);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertLärare(Lärare lärare) {
        String sql = "INSERT INTO Larare VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setInt(1, lärare.getLärarID());
            ps.setString(2, lärare.getNamn());
            ps.setInt(3, lärare.getPersonnummer());
            ps.setString(4, lärare.getKurstillfälleID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteLärare(Lärare lärare) {
        String sql = "DELETE FROM Lärare WHERE LärareID = ?";

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setInt(1, lärare.getLärarID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
