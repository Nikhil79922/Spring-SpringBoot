package com.example.CRUDops.entity;

import com.example.CRUDops.entity.attributes.BooleanToString;
import com.example.CRUDops.entity.enums.StudentStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(
            name= "email",
            unique = true,
            nullable = false,
            length = 100,
            insertable = false,
            updatable = false
    )
    private String email;
    private int age;
    private int rollNo;
    private String subject;
    private boolean deleted;

// For Hibernate Understanding...
//
//    @Enumerated(EnumType.STRING)
//    private StudentStatus status;
//    @Column(precision = 5 , scale=2)
//    private BigDecimal percentage;
//
//    @Transient
//    private String displayName;
//
//    @Convert(converter = BooleanToString.class)
//    private Boolean isMonitor;
//
//    @Lob
//    private String profileDescription;
//
//    @Embedded
//    private Address currentAddress;
//
//
//
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(
//                    name = "country",
//                    column = @Column(name= "permanentCountry")
//            ),
//            @AttributeOverride(
//                    name = "city",
//                    column = @Column(name= "permanentCity")
//            ),
//    })
//    private Address permanentAddress;
//
//    //Joins
//    @ElementCollection
//    @CollectionTable(
//            name= "student_skills",
//            joinColumns = @JoinColumn(name = "student_id")
//    )
//    private Set<String> skills;
//
//

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public boolean isDeleted() {
        return deleted;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return id;
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

    public void setId(long id) {
        this.id = id;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", rollNo=" + rollNo +
                ", subject='" + subject + '\'' +
                '}';
    }
}
