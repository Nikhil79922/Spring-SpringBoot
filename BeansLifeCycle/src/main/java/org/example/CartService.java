package org.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CartService implements BeanNameAware, ApplicationContextAware /* implements InitializingBean */ {
    Map<Integer , String> map;
    public CartService() {
        map = new HashMap<>();
        System.out.println("CartService init");
    }

//    @Override
//    public void afterPropertiesSet() throws Exception{
//        map.put(1, "Nikhil");
//        map.put(2, "Aditya");
//        map.put(3, "Pawan");
//        System.out.println("afterPropertiesSet");
//    }

//    public void start(){
//                map.put(1, "Nikhil");
//        map.put(2, "Aditya");
//        map.put(3, "Pawan");
//        System.out.println("CartService start");
//    }


    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext " + applicationContext.getClass().getName());
    }

    @PostConstruct
    public void startWithAnotations(){
        map.put(1, "Nikhil");
        map.put(2, "Aditya");
        map.put(3, "Pawan");
        System.out.println("startWithAnotations");

    }

    @PreDestroy
    public void stopWithAnotations(){
        map.clear();
        System.out.println("Beans destroyed and Map is flushed");
    }

    public void printAll(){
       for(Map.Entry<Integer, String> entry : map.entrySet()){
           System.out.println(entry.getValue());
       }
    }

}
