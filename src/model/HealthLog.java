package model;


//HealthLog class inherits from HealthRecord (OOP: Inheritance)
public class HealthLog extends HealthRecord {

	// Private variables (OOP: Encapsulation)
    private double bp;
    private double sugar;

    // Constructor to initialize values (OOP: Constructor)
    public HealthLog(String date, double bp, double sugar) {
        super(date); // calling parent class constructor (Inheritance)
        this.bp  = bp;
        this.sugar = sugar;
    }

    // Getter method for blood pressure (Encapsulation)
    public double getBp() {
    	return bp;    }
     
    // Getter method for sugar level (Encapsulation)
    public double getSugar() { 
    	return sugar; }

    
    @Override
    // Overriding parent class method (OOP: Method Overriding / Polymorphism)
    public void displayRecord() {
        System.out.println("Date: " + date + " | BP: " + bp + " | Sugar: " + sugar);
    }
}