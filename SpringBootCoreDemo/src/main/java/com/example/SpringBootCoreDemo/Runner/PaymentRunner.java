package com.example.SpringBootCoreDemo.Runner;

import com.example.SpringBootCoreDemo.PaymentService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component()
public class PaymentRunner implements CommandLineRunner /*ApplicationRunner*/  {

    PaymentService paymentService;

    public PaymentRunner(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.paymentService.print();
        System.out.println("CommandLineRunner run method Executed !!!!!!!!!" );
    }


//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//this.paymentService.print();
//        System.out.println("ApplicationRunner run method Executed !!!!!!!!!" );
//    }
}
