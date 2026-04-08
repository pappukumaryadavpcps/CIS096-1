// Package for utility classes (helper functions)
package util;

//Import SQL classes for database connection
import java.sql.Connection;
import java.sql.DriverManager;

//Class to manage database connection (OOP: Utility Class)
public class DBConnection {

    // Database URL (JDBC connection string)
    private static final String URL      = "jdbc:mysql://localhost:3306/MEDICINE_REMINDER";

    // Database username
    private static final String USER     = "root";
    // Database password
    private static final String PASSWORD = "1230";

    // Static method to get database connection
    public static Connection getConnection() {
        try {
            // Create and return connection object
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            // Handle connection error
            System.out.println("DB Connection Failed: " + e.getMessage());
            return null;
        }
    }
}