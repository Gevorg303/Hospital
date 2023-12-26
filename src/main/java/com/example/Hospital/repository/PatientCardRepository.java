package com.example.Hospital.repository;

import com.example.Hospital.domain.Contract;
import com.example.Hospital.domain.LegalRepresentative;
import com.example.Hospital.domain.PatientCard;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
@Transactional
public class PatientCardRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<PatientCard> findAll() {
        return entityManager.createNativeQuery("SELECT * FROM карточка_пациента", PatientCard.class).getResultList();

    }
    public void save(PatientCard patientCard) {
        entityManager.persist(patientCard);
    }

    public PatientCard findById(String id) {
        return entityManager.find(PatientCard.class, id);
    }

    public PatientCard findByPassportSeriesNumber(String passportSeriesNumber) {
        TypedQuery<PatientCard> query = entityManager.createQuery(
                        "SELECT pc FROM PatientCard pc WHERE pc.passportSeriesNumber = :passportSeriesNumber", PatientCard.class)
                .setParameter("passportSeriesNumber", passportSeriesNumber);

        List<PatientCard> resultList = query.getResultList();

        return resultList.isEmpty() ? null : resultList.get(0);
    }

    public PatientCard getById(String passportSeriesNumber) {
        return entityManager.find(PatientCard.class, passportSeriesNumber);
    }
}

