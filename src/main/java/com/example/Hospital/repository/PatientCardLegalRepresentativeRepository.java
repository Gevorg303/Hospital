package com.example.Hospital.repository;

import com.example.Hospital.domain.PatientCard;
import com.example.Hospital.domain.PatientCardLegalRepresentative;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PatientCardLegalRepresentativeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<PatientCardLegalRepresentative> findAll() {
        return entityManager.createQuery("SELECT p FROM PatientCardLegalRepresentative p", PatientCardLegalRepresentative.class)
                .getResultList();
    }

    public PatientCardLegalRepresentative findById(Long id) {
        return entityManager.find(PatientCardLegalRepresentative.class, id);
    }

    public void save(PatientCardLegalRepresentative patientCardLegalRepresentative) {
        PatientCard patientCard = patientCardLegalRepresentative.getPatientCard();
        if (patientCard != null && patientCard.getPassportSeriesNumber() == null) {
            patientCard = entityManager.merge(patientCard); // Save or update the PatientCard if it's not yet persisted
            patientCardLegalRepresentative.setPatientCard(patientCard); // Set the managed PatientCard instance back to the association
        }
        entityManager.persist(patientCardLegalRepresentative); // Save the PatientCardLegalRepresentative
    }

    public void deleteById(Long id) {
        PatientCardLegalRepresentative entity = entityManager.find(PatientCardLegalRepresentative.class, id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }
}