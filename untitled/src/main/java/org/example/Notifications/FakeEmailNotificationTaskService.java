package org.example.Notifications;

public class FakeEmailNotificationTaskService implements Notifications {
    @Override
    public void sendNotifcations() {
        System.out.println("Testing Email notifications send");
    }
}
