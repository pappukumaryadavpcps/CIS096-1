package util;

import model.Medicine;
import java.sql.*;
import java.util.*;

public class MedicineDAO {

    public static void save(String userEmail, Medicine m) {
        String sql = "INSERT INTO medicines (user_email, name, dosage, time) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, userEmail);
            stmt.setString(2, m.getName());
            stmt.setString(3, m.getDosage());
            stmt.setString(4, m.getTime());
            stmt.executeUpdate();
            System.out.println("Medicine saved to DB.");

        } catch (Exception e) {
            System.out.println("Save medicine error: " + e.getMessage());
        }
    }

    public static List<Medicine> getAll(String userEmail) {
        List<Medicine> list = new ArrayList<>();
        String sql = "SELECT * FROM medicines WHERE user_email = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, userEmail);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Medicine(
                    rs.getString("name"),
                    rs.getString("dosage"),
                    rs.getString("time")
                ));
            }
        } catch (Exception e) {
            System.out.println("Fetch medicine error: " + e.getMessage());
        }
        return list;
    }
}