package com.example.Hospital.repository;

import com.example.Hospital.domain.LegalRepresentative;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class LegalRepresentativeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<LegalRepresentative> findAll() {
        return entityManager.createQuery("SELECT lr FROM LegalRepresentative lr", LegalRepresentative.class)
                .getResultList();
    }


    public void save(LegalRepresentative legalRepresentative) {
        entityManager.persist(legalRepresentative);
    }

    public void deleteById(Long id) {
        LegalRepresentative legalRepresentative = entityManager.find(LegalRepresentative.class, id);
        if (legalRepresentative != null) {
            entityManager.remove(legalRepresentative);
        }
    }
}
