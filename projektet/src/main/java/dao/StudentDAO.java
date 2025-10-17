package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {
     // Path to your database file. Adjust this path as needed.
    // If the file is in the project root, just use the filename.
    private static final String DB_PATH = "student_database.db";
    // Alternatively, use an absolute path like:
    // private static final String DB_PATH = "C:/Users/Matias/Downloads/sqlite-tools-win-x64-3500400/student_database.db";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // 1. Load the SQLite JDBC driver (optional in newer Java versions)
            Class.forName("org.sqlite.JDBC");

            // 2. Establish a connection to the database
            // The URL format is "jdbc:sqlite:path_to_your_db_file"
            connection = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
            System.out.println("Connected to the database successfully!");

            // 3. Create a Statement object to execute SQL queries
            statement = connection.createStatement();

            // Example: Execute a SELECT query
            String query = "SELECT * FROM Student LIMIT 5;"; // Adjust table name as needed
            resultSet = statement.executeQuery(query);

            // 4. Process the results
            System.out.println("Query Results:");
            while (resultSet.next()) {
                // Replace these column names with the actual column names from your "Student" table
                int studentId = resultSet.getInt("StudentID");
                String name = resultSet.getString("Namn");
                int personalNumber = resultSet.getInt("Personnummer");
                int yearGroup = resultSet.getInt("Arskull");

                System.out.println("StudentID: " + studentId + ", Name: " + name + ", SSN: " + personalNumber + ", Year Group: " + yearGroup);
            }

        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
        } finally {
            // 5. Close resources in the reverse order of opening (ResultSet -> Statement -> Connection)
            try {
                if (resultSet != null) resultSet.close();
            } catch (SQLException e) {
                System.err.println("Error closing ResultSet: " + e.getMessage());
            }
            try {
                if (statement != null) statement.close();
            } catch (SQLException e) {
                System.err.println("Error closing Statement: " + e.getMessage());
            }
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing Connection: " + e.getMessage());
            }
            System.out.println("Database connection closed.");
        }
    }
}
