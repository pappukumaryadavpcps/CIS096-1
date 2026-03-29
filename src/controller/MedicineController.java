package controller;

import model.AppData;
import model.Medicine;

public class MedicineController {

    public void addMedicine(Medicine m) {
        AppData.addMedicine(m);  // saves to shared store
        System.out.println("Added: " + m.getName());
    }
}