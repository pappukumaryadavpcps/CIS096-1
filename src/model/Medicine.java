package model;

//Class representing Medicine entity (OOP: Class)
public class Medicine {
	
    // Private variables (OOP: Encapsulation)
    private String name;
    private String dosage;   // fixed: was __dosage__
    private String time;

    
    // Constructor to initialize medicine details (OOP: Constructor)
    public Medicine(String name, String dosage, String time) {
        this.name   = name;
        this.dosage = dosage;
        this.time   = time;
    }

    // Getter method for name (Encapsulation)
    public String getName()   { return name;   }
    
    // Getter method for dosage (Encapsulation)
    public String getDosage() { return dosage; }
    
    // Getter method for time (Encapsulation)
    public String getTime()   { return time;   }
}