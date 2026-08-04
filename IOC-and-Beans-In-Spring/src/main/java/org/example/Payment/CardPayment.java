package org.example.Payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Card")
public class CardPayment implements PaymentService {
    @Override
    public void pay() {
        System.out.println("Paying via Card");
    }
}
