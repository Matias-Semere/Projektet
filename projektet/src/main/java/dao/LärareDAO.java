package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Lärare;

public class LärareDAO {

    public List<Lärare> getAllLärare() {
        List<Lärare> L = new ArrayList<>();
        try (Statement stmt = DataBase.getConnection().createStatement()) {
            String sql = "SELECT * FROM Lärare";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Lärare l = new Lärare(rs.getInt("LärareID"), rs.getString("Namn"), rs.getInt("Personnummer"),
                        rs.getInt("KurstillfälleID"));
                L.add(l);
                System.out.println(l);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return L;
    }

    public void insertLärare(Lärare lärare) {
        String sql = "INSERT INTO Lärare VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setInt(1, lärare.getLärarID());
            ps.setString(2, lärare.getNamn());
            ps.setInt(3, lärare.getPersonnummer());
            ps.setInt(4, lärare.getKurstillfälleID());
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

    public void alterLärare(Lärare lärare) {
        String sql = "UPDATE Lärare SET Namn = ?, LärareID = ?, Personnummer = ?, KurstilfälleID = ?, WHERE LärareID = ?";
        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setString(1, lärare.getNamn());
            ps.setInt(2, lärare.getLärarID());
            ps.setInt(3, lärare.getPersonnummer());
            ps.setInt(4, lärare.getKurstillfälleID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

}
