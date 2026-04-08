// Package for utility / DAO layer (handles database operations)
package util;

//Import model class (OOP: Object usage)
import model.HealthLog;
import java.sql.*;
import java.util.*;

//DAO class for HealthLog (MVC: Data Access Object)
public class HealthLogDAO {


    // Method to save HealthLog into database
    public static void save(String userEmail, HealthLog log) {
        // SQL query with placeholders (PreparedStatement)
        String sql = "INSERT INTO health_logs (user_email, date, bp, sugar) VALUES (?, ?, ?, ?)";
        // Get database connection
        try (Connection conn = DBConnection.getConnection();
                // Create prepared statement
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Set values in query (Parameter binding)
            stmt.setString(1, userEmail);
            stmt.setString(2, log.getDate());  // Encapsulation (getter)
            stmt.setDouble(3, log.getBp());
            stmt.setDouble(4, log.getSugar());
            // Execute insert query
            stmt.executeUpdate();
            // Exception handling
            System.out.println("Health log saved to DB.");

        } catch (Exception e) {
            System.out.println("Save log error: " + e.getMessage());
        }
    }

    // Method to fetch all health logs of a user
    public static List<HealthLog> getAll(String userEmail) {
    	   // Create list to store objects (Collection Framework)
        List<HealthLog> list = new ArrayList<>();
        // SQL query
        String sql = "SELECT * FROM health_logs WHERE user_email = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Set parameter
            stmt.setString(1, userEmail);
            // Execute select query
            ResultSet rs = stmt.executeQuery();
            // Loop through result set (Iteration)
            while (rs.next()) {
                // Create object from DB data (OOP: Object Creation)
                list.add(new HealthLog(
                    rs.getString("date"),
                    rs.getDouble("bp"),
                    rs.getDouble("sugar")
                ));
            }
        } catch (Exception e) {
            System.out.println("Fetch log error: " + e.getMessage());
        }

        // Return list of objects
        return list;
    }
}