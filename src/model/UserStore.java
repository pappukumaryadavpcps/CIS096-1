package model;

import java.util.HashMap;
import java.util.Map;

/**
 * In-memory user store shared across LoginUI and SignupUI.
 * Fixes the core bug: registered credentials are now persisted
 * for the duration of the app session.
 */
public class UserStore {

    private static final Map<String, String> users = new HashMap<>();

    public static void register(String email, String password) {
        users.put(email.toLowerCase(), password);
    }

    public static boolean validate(String email, String password) {
        String stored = users.get(email.toLowerCase());
        return stored != null && stored.equals(password);
    }

    public static boolean exists(String email) {
        return users.containsKey(email.toLowerCase());
    }
}