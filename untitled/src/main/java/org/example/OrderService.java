package org.example;

import org.example.Notifications.Notifications;

public class OrderService {
    private Notifications notifications;

    public OrderService(Notifications notifications) {
        this.notifications = notifications;
    }
    public void placeOrder(){
        System.out.println("Placing order");
        this.notifications.sendNotifcations();
    }

    public void setNotifications(Notifications notifications) {
        this.notifications = notifications;
    }
}
