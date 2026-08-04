package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example")
public class AppConfig {
@Bean
    public OrderService orderService(){
    return new OrderService();
}

@Bean
    public OrderService orderService2(){
    return new OrderService();
}
}
