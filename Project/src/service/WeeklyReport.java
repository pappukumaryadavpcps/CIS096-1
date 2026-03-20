package service;

import model.ReportGenerator;

public class WeeklyReport implements ReportGenerator {

    @Override
    public void generateReport() {
        System.out.println("Weekly Report Generated");
    }
}
