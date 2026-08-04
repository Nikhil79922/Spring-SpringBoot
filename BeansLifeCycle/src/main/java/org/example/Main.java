package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        ApplicationContext context  = new AnnotationConfigApplicationContext(AppConfig.class);
        ConfigurableApplicationContext context  = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = context.getBean(OrderService.class);
        orderService.placeOrder();

        AppConfig config = context.getBean(AppConfig.class);
        config.demo();

        CartService cs = context.getBean(CartService.class);
        cs.printAll();

        context.close(); // destroy beans
    }

}