package com.example.hibernateDemo.repository;

import com.example.hibernateDemo.entity.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Department department) {
        entityManager.persist(department);
    }

    public Department getByDepartmentId(Long id) {
        return entityManager.find(Department.class, id);
    }
    public void delete(Department department) {
         entityManager.remove(department);
    }
}
