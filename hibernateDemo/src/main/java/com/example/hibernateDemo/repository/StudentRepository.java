package com.example.hibernateDemo.repository;
import com.example.hibernateDemo.entity.Department;
import com.example.hibernateDemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Student student) {
        entityManager.persist(student);
    }

    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

//    @EntityGraph(attributePaths = "department") // Works with Spring JPA..
    public List<Student> findAll() {
        return entityManager
                .createQuery(
                        "SELECT s FROM Student s JOIN FETCH s.department",
                        Student.class
                )
                .getResultList();
    }

}