package com.example.hibernateDemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "dept_id",
            nullable = false
    )
    private Department department;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name= "profile_id",
            nullable = false
    )
    private Profile2 profile;



}
