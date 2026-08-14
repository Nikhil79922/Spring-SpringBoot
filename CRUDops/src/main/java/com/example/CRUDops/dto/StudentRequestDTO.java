package com.example.CRUDops.dto;


import jakarta.validation.constraints.*;
import org.springframework.format.annotation.NumberFormat;

public class StudentRequestDTO {
    @NotBlank(message = "Name can't be Empty or Null")
    @Size(message="Invalid name is not allowed " , min = 2 ,max = 30)
    private String name;

    @NotBlank(message = "email is not ")
    @Email(message = "Email is required , can't be empty")
    private String email;

    @Min(message = "Less then 18 is not allowed", value = 18)
    @Max(message = "Age is too high" , value = 70)
    @NotNull(message = "Age field is required")
    private int age;

    @NotNull(message = "Roll no is required field")
    private Integer rollNo;

    @NotBlank(message= "Subject is required field")
    private String subject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


}
