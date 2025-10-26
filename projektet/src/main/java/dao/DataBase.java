package dao;
import java.io.*;
import java.nio.file.*;
import java.sql.*;

public class DataBase {

    private static final String DB_PATH = System.getProperty("user.dir") + "/student_database.db";
    private static Connection connection;

    static {
        try {
            File dbFile = new File(DB_PATH);
            if (!dbFile.exists()) {
                InputStream in = StudentDAO.class.getResourceAsStream("/student_database.db");
                Files.copy(in, dbFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Databasen skapades!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private DataBase() {}

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
                try (Statement stmt = connection.createStatement()) {
                    stmt.execute("PRAGMA foreign_keys = ON;");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
