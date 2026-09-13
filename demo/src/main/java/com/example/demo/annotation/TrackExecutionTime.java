package com.example.demo.annotation;

import java.lang.annotation.*;

//marker annotations :- if no config is available
//Configured annotation :- if method config are available
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)  // byDefault it is Runtime
@Documented
public @interface TrackExecutionTime {
    long warnAfter() default 0;
    String operation() default "";
}
