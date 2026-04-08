package model;

//Abstract class representing a general health record (OOP: Abstraction)
public abstract class HealthRecord {

	// Protected variable accessible in child classes (Encapsulation + Inheritance)
    protected String date;

    // Constructor to initialize date (OOP: Constructor)
    public HealthRecord(String date) {
        this.date = date;
    }
    
    // Getter method to access date (Encapsulation)
    public String getDate()
    {
    	return date; }

 
    // Abstract method (no implementation) → must be implemented by child class (Abstraction)
    public abstract void displayRecord();
}
