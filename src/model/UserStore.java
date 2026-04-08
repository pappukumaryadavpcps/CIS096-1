package model;

//Import Map and HashMap for key-value storage (Collection Framework)
import java.util.HashMap;
import java.util.Map;

//Class to store user data (OOP: Class)
public class UserStore {

    // Map to store email and password (OOP: Collection + Object)
    private static final Map<String, String> users = new HashMap<>();

    // Method to register a new user (OOP: Method)
    public static void register(String email, String password) {
    	
        // Store email (in lowercase) and password in map
        users.put(email.toLowerCase(), password);
    }

    // Method to validate user login
    public static boolean validate(String email, String password) {
    	
        // Get stored password using email
        String stored = users.get(email.toLowerCase());
        // Check if user exists and password matches
        return stored != null && stored.equals(password);
    }

    // Method to check if user already exists
    public static boolean exists(String email) {
        // Check if email key is present in map
        return users.containsKey(email.toLowerCase());
    }
}