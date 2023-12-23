package com.example.Hospital.repository;

import com.example.Hospital.domain.Education;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EducationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Education> findAll() {
        return entityManager.createQuery("SELECT e FROM Education e", Education.class).getResultList();
    }

    public Education findById(Long id) {
        return entityManager.find(Education.class, id);
    }

    public void save(Education education) {
        entityManager.persist(education);
    }

    public void update(Education education) {
        entityManager.merge(education);
    }

    public void delete(Long id) {
        Education education = findById(id);
        if (education != null) {
            entityManager.remove(education);
        }
    }
    @Transactional
    public void deleteById(Long id) {
        Education education = entityManager.find(Education.class, id);
        if (education != null) {
            entityManager.remove(education);
        }
    }

}

