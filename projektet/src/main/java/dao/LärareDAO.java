package dao;

import model.Lärare;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LärareDAO {

    public List<Lärare> getAllLärare() {
        List<Lärare> list = new ArrayList<>();
        String sql = "SELECT * FROM Lärare";

        try (Statement stmt = DataBase.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Lärare(
                        rs.getInt("LärareID"),
                        rs.getInt("UserID"),
                        rs.getString("Namn")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Lärare getLärare(int lärareID) {
        String sql = "SELECT * FROM Lärare WHERE LärareID = ?";
        Lärare l = null;

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setInt(1, lärareID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    l = new Lärare(
                            rs.getInt("LärareID"),
                            rs.getInt("UserID"),
                            rs.getString("Namn")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return l;
    }

    public void insertLärare(Lärare lärare) {
        String sql = "INSERT INTO Lärare (UserID, Namn) VALUES (?, ?)";

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, lärare.getUserID());
            ps.setString(2, lärare.getNamn());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    lärare.setLärareID(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterLärare(Lärare lärare) {
        String sql = "UPDATE Lärare SET Namn = ?, UserID = ? WHERE LärareID = ?";

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setString(1, lärare.getNamn());
            ps.setInt(2, lärare.getUserID());
            ps.setInt(3, lärare.getLärareID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteLärare(Lärare lärare) {
        String sql = "DELETE FROM Lärare WHERE LärareID = ?";

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(sql)) {
            ps.setInt(1, lärare.getLärareID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
