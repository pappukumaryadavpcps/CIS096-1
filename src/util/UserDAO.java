// Package for DAO layer (database operations)
package util;

//Import SQL classes for JDBC
import java.sql.*;

//DAO class for user authentication (MVC: Data Access Object)
public class UserDAO {

    // Method to register new user in database
    public static boolean register(String email, String password) {
        // SQL insert query
        String sql = "INSERT INTO users (email, password) VALUES (?, ?)";
        // Get database connection
        try (Connection conn = DBConnection.getConnection();
                // Create prepared statement
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Set values (convert email to lowercase)
            stmt.setString(1, email.toLowerCase());
            stmt.setString(2, password);

            // Execute insert query
            stmt.executeUpdate();
            return true;// success

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handles duplicate email error
            System.out.println("Email already exists.");
            return false;
        } catch (Exception e) {
            // General exception handling
            System.out.println("Register error: " + e.getMessage());
            return false;
        }
    }

    // Method to validate user login
    public static boolean validate(String email, String password) {
        // SQL select query
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Set parameters
            stmt.setString(1, email.toLowerCase());
            stmt.setString(2, password);
            // Execute query
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // true if a match is found

        } catch (Exception e) {
            System.out.println("Login error: " + e.getMessage());
            return false;
        }
    }

    // Check if email already registered
    public static boolean exists(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email.toLowerCase());
            ResultSet rs = stmt.executeQuery();
            return rs.next();// true if email found

        } catch (Exception e) {
            return false;
        }
    }
}