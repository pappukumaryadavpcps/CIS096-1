package util;

import model.HealthLog;
import java.sql.*;
import java.util.*;

public class HealthLogDAO {

    public static void save(String userEmail, HealthLog log) {
        String sql = "INSERT INTO health_logs (user_email, date, bp, sugar) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, userEmail);
            stmt.setString(2, log.getDate());
            stmt.setDouble(3, log.getBp());
            stmt.setDouble(4, log.getSugar());
            stmt.executeUpdate();
            System.out.println("Health log saved to DB.");

        } catch (Exception e) {
            System.out.println("Save log error: " + e.getMessage());
        }
    }

    public static List<HealthLog> getAll(String userEmail) {
        List<HealthLog> list = new ArrayList<>();
        String sql = "SELECT * FROM health_logs WHERE user_email = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, userEmail);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new HealthLog(
                    rs.getString("date"),
                    rs.getDouble("bp"),
                    rs.getDouble("sugar")
                ));
            }
        } catch (Exception e) {
            System.out.println("Fetch log error: " + e.getMessage());
        }
        return list;
    }
}