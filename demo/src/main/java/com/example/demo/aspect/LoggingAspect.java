package com.example.demo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(String com.example.demo.service.StudentService.createStudent())")
    public void logBeforeMethod() {
        System.out.println("Student is going to be saved...");
    }

    @AfterReturning( value =
            "execution(String com.example.demo.service.StudentService.createStudent())",
             returning =  "result")
    public void logBeforeMethod() {
        System.out.println("Student is going to be saved...");
    }



    @After("execution(String com.example.demo.service.StudentService.createStudent())")
    public void logAfterMethod() {
        System.out.println("Student is saved successfully 🎉");
    }
}
