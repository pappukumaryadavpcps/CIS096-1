package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Shared in-memory store for medicines and health logs.
 */
public class AppData {

    // Medicine tracking
    private static List<Medicine> medicines = new ArrayList<>();
    private static int missedDoses = 0;

    // Health log tracking
    private static List<HealthLog> healthLogs = new ArrayList<>();

    // --- Medicine methods ---
    public static void addMedicine(Medicine m) {
        medicines.add(m);
    }

    public static int getMedicineTakenCount() {
        return medicines.size();
    }

    public static void incrementMissedDoses() {
        missedDoses++;
    }

    public static int getMissedDoses() {
        return missedDoses;
    }

    // --- Health Log methods ---
    public static void addHealthLog(HealthLog log) {
        healthLogs.add(log);
    }

    public static double getAvgBP() {
        if (healthLogs.isEmpty()) return 0;
        double sum = 0;
        for (HealthLog h : healthLogs) sum += h.getBp();
        return Math.round((sum / healthLogs.size()) * 10.0) / 10.0;
    }

    public static double getAvgSugar() {
        if (healthLogs.isEmpty()) return 0;
        double sum = 0;
        for (HealthLog h : healthLogs) sum += h.getSugar();
        return Math.round((sum / healthLogs.size()) * 10.0) / 10.0;
    }
}