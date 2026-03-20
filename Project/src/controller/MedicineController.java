package controller;

import model.Medicine;

public class MedicineController {

    public void addMedicine(Medicine m) {
        System.out.println("Added: " + m.getName());
    }
}
