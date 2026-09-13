package com.example.SpringBootCoreDemo;

import com.example.SpringBootCoreDemo.Configurations.PaymentConfigurations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {
//Values annotation Approach
//    @Value("${paymentGateway.type:RazorPay}")
//    private  String type;
//
//    public String getType() {
//        return type;
//    }
//
//    public int getRetry_count() {
//        return retry_count;
//    }
//
//    @Value("${paymentGateway.retry_count}")
//    private  int retry_count;
//


    public void pay(){
        System.out.println("Payed ");
    }



    //Industry Practice
    //ConfigurationProperty Annotation
    PaymentConfigurations paymentConfigurations;
    public PaymentService(PaymentConfigurations paymentConfigurations) {
        this.paymentConfigurations = paymentConfigurations;
    }

    public String getType() {
        return this.paymentConfigurations.getType();
    }

    public int getRetry_count() {
        return this.paymentConfigurations.getRetry_count();
    }

    public boolean isEnabled() {
        return this.paymentConfigurations.isEnabled();
    }

    public int getTime_out() {
        return this.paymentConfigurations.getTime_out();
    }

    public void print(){
        System.out.println( this.getType() ) ;
        System.out.println( this.getRetry_count() ) ;
        System.out.println( this.getTime_out() ) ;
        System.out.println( this.isEnabled() );
    }
}
