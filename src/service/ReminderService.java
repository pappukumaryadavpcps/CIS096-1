
// Package for service layer (handles business logic)
package service;

//Import Reminder class (OOP: Object usage)
import model.Reminder;
import java.util.List;

//Service class to handle reminder operations (OOP: Class)
public class ReminderService {


    // Method to check and trigger reminders (OOP: Method)
    public void checkReminders(List<Reminder> reminders) {

        // Loop through all Reminder objects (Collection + Loop)
        for (Reminder r : reminders) {
        	
            // Call method of Reminder object (OOP: Object interaction)
            r.sendNotification();
        }
    }
}