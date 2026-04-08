// Package for controller layer (handles logic between UI and model)
package controller;

// Import model classes
import model.AppData;
import model.Medicine;

// Controller class to manage medicine-related operations
public class MedicineController {

    // Method to add a new medicine
    public void addMedicine(Medicine m) {

        // Call AppData class to store medicine in shared data list
        AppData.addMedicine(m);

        // Print confirmation message in console
        System.out.println("Added: " + m.getName());
    }
}