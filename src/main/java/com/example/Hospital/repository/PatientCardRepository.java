package com.example.Hospital.repository;

import com.example.Hospital.domain.PatientCard;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PatientCardRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<PatientCard> findAll() {
        return entityManager.createNativeQuery("SELECT * FROM карточка_пациента", PatientCard.class).getResultList();

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
        entityManager.remove(patientCard);
    }

    public PatientCard findById(Long id) {
        return entityManager.find(PatientCard.class, id);
    }
    public PatientCard findByPassportSeriesNumber(String passportSeriesNumber) {
        return entityManager.createQuery("SELECT pc FROM PatientCard pc WHERE pc.passportSeriesNumber = :passportSeriesNumber", PatientCard.class)
                .setParameter("passportSeriesNumber", passportSeriesNumber)
                .getSingleResult();
    }
}


