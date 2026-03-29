package model;

public abstract class HealthRecord {

    protected String date;

    public HealthRecord(String date) {
        this.date = date;
    }
    public String getDate() { return date; }

    // abstract method (no body)
    public abstract void displayRecord();
}
