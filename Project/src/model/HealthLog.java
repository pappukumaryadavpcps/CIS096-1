package model;

public class HealthLog extends HealthRecord {

    private double bp;
    private double sugar;

    public HealthLog(String date, double bp, double sugar) {
        super(date);
        this.bp = bp;
        this.sugar = sugar;
    }

    @Override
    public void displayRecord() {
        System.out.println("Date: " + date + " BP: " + bp);
    }
}
