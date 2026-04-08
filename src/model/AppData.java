package model;


//Import required classes for list operations (Collection Framework)
import java.util.ArrayList;
import java.util.List;


//Class represents a shared data storage (OOP: Class concept)
public class AppData {

	  // OOP: Object + Collection → storing multiple Medicine objects
    private static List<Medicine> medicines = new ArrayList<>();
    
    // Static variable shared across whole application
    private static int missedDoses = 0;

    // OOP: Object → storing HealthLog objects
    private static List<HealthLog> healthLogs = new ArrayList<>();

    // --- Medicine methods ---
    // OOP: Method + Object Passing → receiving Medicine object
    public static void addMedicine(Medicine m) {
        medicines.add(m);  // storing object in list
    }

    // OOP: Method → returning value
    public static int getMedicineTakenCount() {
        return medicines.size();
    }
    // Method to update missed dose count
    public static void incrementMissedDoses() {
        missedDoses++;
    }
    // Method to return missed doses
    public static int getMissedDoses() {
        return missedDoses;
    }

    // --- Health Log methods ---
    public static void addHealthLog(HealthLog log) {
        healthLogs.add(log);
    }

    // OOP: Abstraction → hiding calculation logic inside method
    public static double getAvgBP() {
        // Control statement
        if (healthLogs.isEmpty()) return 0;
        double sum = 0;
        // OOP: Object usage + Loop
        for (HealthLog h : healthLogs) 
        	sum += h.getBp(); // OOP: Encapsulation → accessing private data using getter
        
        // Returning calculated result
        return Math.round((sum / healthLogs.size()) * 10.0) / 10.0;
    }

    // OOP: Abstraction
    public static double getAvgSugar() {
        if (healthLogs.isEmpty()) return 0;
        double sum = 0;
        // Loop through objects
        for (HealthLog h : healthLogs)
        	sum += h.getSugar();    // OOP: Encapsulation
        return Math.round((sum / healthLogs.size()) * 10.0) / 10.0;
    }
}