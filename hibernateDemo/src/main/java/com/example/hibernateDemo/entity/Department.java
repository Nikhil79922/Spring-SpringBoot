package com.example.hibernateDemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

//    @OneToMany(
//            mappedBy = "department",
//            cascade = {
//                    CascadeType.PERSIST,
//                    CascadeType.REMOVE
//            }
//
//    )
//    private List<Student> students = new ArrayList<>();
}
