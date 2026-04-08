// Package for DAO layer (database operations)
package util;

//Import model class (OOP: Object usage)
import model.Medicine;
import java.sql.*;
import java.util.*;

//DAO class for Medicine (MVC: Data Access Object)
public class MedicineDAO {

    // Method to save Medicine object into database
    public static void save(String userEmail, Medicine m) {
        // SQL query with placeholders (PreparedStatement)
        String sql = "INSERT INTO medicines (user_email, name, dosage, time) VALUES (?, ?, ?, ?)";
        // Get database connection
        try (Connection conn = DBConnection.getConnection();
        	       // Create prepared statement
             PreparedStatement stmt = conn.prepareStatement(sql)) {

        	  // Set values into query (Encapsulation via getters)
            stmt.setString(1, userEmail);
            stmt.setString(2, m.getName());
            stmt.setString(3, m.getDosage());
            stmt.setString(4, m.getTime());
            // Execute insert query
            stmt.executeUpdate();
            System.out.println("Medicine saved to DB.");

        } catch (Exception e) {
            // Exception handling
            System.out.println("Save medicine error: " + e.getMessage());
        }
    }

    // Method to fetch all medicines of a user
    public static List<Medicine> getAll(String userEmail) {
        // Create list to store objects (Collection Framework)
        List<Medicine> list = new ArrayList<>();
        // SQL query
        String sql = "SELECT * FROM medicines WHERE user_email = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Set parameter
            stmt.setString(1, userEmail);
            // Execute select query
            ResultSet rs = stmt.executeQuery();
            // Loop through result set
            while (rs.next()) {
                // Create Medicine object from DB data (OOP)
                list.add(new Medicine(
                    rs.getString("name"),
                    rs.getString("dosage"),
                    rs.getString("time")
                ));
            }
        } catch (Exception e) {
            System.out.println("Fetch medicine error: " + e.getMessage());
        }
        // Return list of medicines
        return list;
    }
}