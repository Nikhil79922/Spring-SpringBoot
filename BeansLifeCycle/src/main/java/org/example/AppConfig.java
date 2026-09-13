package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example")
public class AppConfig {

    //Init method
//@Bean(initMethod = "start")
//public CartService invokeCart(){
//    return new  CartService();
//    }

    public void demo() {
        System.out.println("demo");
    }
}
