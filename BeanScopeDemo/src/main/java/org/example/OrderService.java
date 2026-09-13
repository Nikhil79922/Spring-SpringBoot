package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class OrderService {
//    @Autowired
//    PaymentService paymentService;

    public OrderService() {
        System.out.println("OrderService Created");
    }

    public void placeOrder() {
        System.out.println("order placed");
        getOrderDetails();
    }

    public void getOrderDetails(){
        System.out.println("Order details fetched");
    }
}
