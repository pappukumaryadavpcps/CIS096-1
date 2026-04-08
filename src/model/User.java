package model;

//Class representing user entity (OOP: Class)
public class User {
	
	// Private variables to store user data (OOP: Encapsulation)
    private String email;
    private String password;

    // Constructor to initialize user details (OOP: Constructor)
    public User(String email, String password) {
        this.email    = email;  // this refers to current object
        this.password = password;
    }

    // Method to validate login credentials (OOP: Method)
    public boolean login(String email, String password) {
    	
    	// Compare entered values with stored values
        return this.email.equals(email) && this.password.equals(password);
    }
}