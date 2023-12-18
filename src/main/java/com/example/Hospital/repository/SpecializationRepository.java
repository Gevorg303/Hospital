package com.example.Hospital.repository;

import com.example.Hospital.domain.Specialization;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class SpecializationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Specialization> findAllSpecializations() {
        return entityManager.createQuery("SELECT s FROM Specialization s", Specialization.class)
                .getResultList();
    }

    public void save(Specialization specialization) {
        entityManager.persist(specialization);
    }

    public void deleteSpecialization(Long id) {
        Specialization specialization = entityManager.find(Specialization.class, id);
        if (specialization != null) {
            entityManager.remove(specialization);
        }
    }
}
