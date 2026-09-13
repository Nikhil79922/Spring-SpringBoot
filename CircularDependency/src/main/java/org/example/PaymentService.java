package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {
    @Autowired
    OrderService orderService;

//    @Autowired
//    public PaymentService(OrderService orderService) {
//        this.orderService = orderService;
//    }

    public void  processPayment() {
        System.out.println("processPayment...");

        orderService.getOrderDetails();

    }
}
