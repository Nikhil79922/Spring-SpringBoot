package com.example.SpringBootCoreDemo;

import org.springframework.stereotype.Component;

@Component
public class OrderService {

    PaymentService paymentService;
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    public  void placeOrder() {
        this.paymentService.pay();
        System.out.println("Order placed");
    }
}
