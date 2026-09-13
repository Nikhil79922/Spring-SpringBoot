package org.example.Notifications;

public class SmsService implements Notifications {
    @Override
    public void sendNotifcations() {
        System.out.println("Sms notifications send");
    }
}
