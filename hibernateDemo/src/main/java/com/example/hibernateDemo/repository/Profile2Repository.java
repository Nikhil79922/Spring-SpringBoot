package com.example.hibernateDemo.repository;

import com.example.hibernateDemo.entity.Profile2;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class Profile2Repository {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Profile2 profile) {
        entityManager.persist(profile);
    }
}
