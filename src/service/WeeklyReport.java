// Package for service layer
package service;

//Import interface (OOP: Abstraction)
import model.ReportGenerator;

//Class implementing ReportGenerator interface (OOP: Interface + Polymorphism)
public class WeeklyReport implements ReportGenerator {

	// Implementing abstract method from interface (Polymorphism)
    @Override
    public void generateReport() {
        // Display weekly report message
        System.out.println("Weekly Report Generated");
    }
}

