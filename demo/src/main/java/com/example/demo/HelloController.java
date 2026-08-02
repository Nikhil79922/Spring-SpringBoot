package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()

public class HelloController {
    @GetMapping("hello")
    public String hello() {
//        System.out.println("Hello World");
        return "<h1> Hello <br> World </h1>";
    }

    @GetMapping("bye")
    public String GreetBye() {
//        System.out.println("Hello World");
        return "<h1> Bye <br> Bye... </h1>";
    }
}
