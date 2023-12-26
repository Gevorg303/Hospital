package com.example.Hospital.repository;


import com.example.Hospital.domain.Records;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecordsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Records> getAllRecords() {
        return entityManager.createQuery("SELECT r FROM Records r", Records.class).getResultList();
    }

    @Transactional
    public void addRecord(Records record) {
        entityManager.persist(record);
    }

    @Transactional
    public void deleteRecord(Long id) {
        Records record = entityManager.find(Records.class, id);
        if (record != null) {
            entityManager.remove(record);
        }
    }

    public Records findById(Long id) {
        return entityManager.find(Records.class, id);
    }
}

