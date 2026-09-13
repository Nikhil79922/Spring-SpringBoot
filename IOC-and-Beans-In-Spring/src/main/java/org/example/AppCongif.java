package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example")
public class AppCongif {
  @Bean
    public User getUser(){
      return new User("Nikhil" , "nikkssy.dev@gmail.com");
  }
}
