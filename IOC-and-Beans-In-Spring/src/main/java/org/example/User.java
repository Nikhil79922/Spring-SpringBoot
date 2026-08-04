package org.example;

import org.springframework.stereotype.Component;

//@Component  -> will give error as input needed
public class User {
    private String name;
    private String email;


     public  User(String name, String email) {
         this.name = name;
         this.email = email;
     }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
}
