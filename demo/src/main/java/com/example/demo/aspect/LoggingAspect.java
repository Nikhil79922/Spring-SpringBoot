package com.example.demo.aspect;

import com.example.demo.annotation.TrackExecutionTime;
import com.example.demo.dto.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

//    @Before("execution(com.example.demo.dto.Student com.example.demo.service.StudentService.createStudent(com.example.demo.dto.Student))")
//    public void logBeforeMethod( JoinPoint joinPoint) {
//        Object[] args = joinPoint.getArgs();
//        System.out.println("Student is going to be saved...");
//    }
//
//    @AfterReturning(
//            value = "execution(com.example.demo.dto.Student com.example.demo.service.StudentService.createStudent(com.example.demo.dto.Student))",
//            returning = "result"
//    )
//    public void logAfterReturningMethod(Student result) {
//        result.setAge(22);
//        result.setName("John");
//    }
//
//    @After("execution(String com.example.demo.service.StudentService.createStudent())")
//    public void logAfterMethod() {
//        System.out.println("Student is saved successfully 🎉");
//    }

    @Around("@annotation(trackExecutionTime)")
    public Object around(ProceedingJoinPoint joinPoint , TrackExecutionTime trackExecutionTime) throws Throwable {
        long start = System.currentTimeMillis();

        try{
            return joinPoint.proceed();
        }finally {
            long end = System.currentTimeMillis();
            long duration = end - start;
            String operation = trackExecutionTime.operation();
            if(operation.isBlank()){
                operation = "TrackExecutionTime annotations ops";
            }
            long warnAfter = trackExecutionTime.warnAfter();
            if(warnAfter <= duration){
                System.out.println("SLOW OPERATION ALERT : " + "Time consumed for the " + operation + " execution : " + duration);
            }else {
                System.out.println("Time consumed for the " + operation + " execution : " + duration);
            }

        }
    }
}
