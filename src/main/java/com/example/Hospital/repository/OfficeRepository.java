package com.example.Hospital.repository;

import com.example.Hospital.domain.Office;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class OfficeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Office findById(Long id) {
        return entityManager.find(Office.class, id);
    }

    public List<Office> findAll() {
        return entityManager.createQuery("SELECT o FROM Office o", Office.class).getResultList();
    }

    public void delete(Office office) {
        entityManager.remove(entityManager.contains(office) ? office : entityManager.merge(office));
    }
    public void save(Office office) {
        entityManager.persist(office);
    }
}