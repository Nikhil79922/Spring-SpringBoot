package org.example;

import org.example.Payment.PaymentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

//    //Field Injection
//    @Autowired
    PaymentService paymentService;


    //Constructor Injection (Most recommended Approach) and if single constructor is there Autowire is not required cause by default it add the @Autowire
//    @Autowired
    public OrderService(@Qualifier("UPI") PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    //Setter Injection
//    @Autowired
//    public void setPaymentService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }

    public void placeOrder() {
        paymentService.pay();
        System.out.println("Order placed");
    }
}
