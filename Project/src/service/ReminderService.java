package service;

import model.Reminder;
import java.util.List;

public class ReminderService {

    public void checkReminders(List<Reminder> reminders) {
        for (Reminder r : reminders) {
            r.sendNotification();
        }
    }
}