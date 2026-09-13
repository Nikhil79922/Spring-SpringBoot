package org.example;

import org.example.Notifications.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Dependency Injections implemented , can we done through constructor or even through setter
//        Notifications notificationServices = new PopUpNotificationService();
        Notifications notificationServices = new EmailNotifications();
//        Notifications notificationServices = new SmsService();
//        Notifications notificationServices = new FakeEmailNotificationTaskService();


        OrderService orderService = new OrderService(notificationServices); // Injections :- notification service injected
        orderService.placeOrder();

    }
}