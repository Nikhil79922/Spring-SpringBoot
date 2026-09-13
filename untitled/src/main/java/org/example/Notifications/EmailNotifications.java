package org.example.Notifications;

public class EmailNotifications implements Notifications {
    @Override
    public void sendNotifcations() {
        System.out.println("Email notifications send");
    }
}
