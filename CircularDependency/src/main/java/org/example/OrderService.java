package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    @Autowired
    PaymentService paymentService;

//    @Autowired
//    public OrderService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }

    public void placeOrder() {
        paymentService.processPayment();
        System.out.println("order placed");
        getOrderDetails();
    }

    public void getOrderDetails(){
        System.out.println("Order details fetched");
    }
}
