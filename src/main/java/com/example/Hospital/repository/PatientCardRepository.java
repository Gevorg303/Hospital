package com.example.Hospital.repository;

import com.example.Hospital.domain.PatientCard;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientCardRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<PatientCard> findAll() {
        return entityManager.createQuery("SELECT c FROM PatientCard c", PatientCard.class).getResultList();
    }

    public PatientCard save(PatientCard patientCard) {
        if (patientCard.getPassportSeriesNumber() == null) {
            entityManager.persist(patientCard);
        } else {
            patientCard = entityManager.merge(patientCard);
        }
        return patientCard;
    }
    public void delete(PatientCard patientCard) {
        entityManager.remove(entityManager.contains(patientCard) ? patientCard : entityManager.merge(patientCard));
    }
}


