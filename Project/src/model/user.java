package model;

public class user {
    private String email;
    private String password;

    public user(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public boolean login(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }
}