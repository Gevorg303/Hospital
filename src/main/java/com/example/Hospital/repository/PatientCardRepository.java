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
    public PatientCard save(PatientCard patientCard) {
        return entityManager.merge(patientCard);
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


    public List<Record> findRecordsByPatientCard(PatientCard patientCard) {
        return entityManager.createQuery("SELECT r FROM Record r WHERE r.patientCard = :patientCard", Record.class)
                .setParameter("patientCard", patientCard)
                .getResultList();
    }

    public List<Contract> findContractsByPatientCard(PatientCard patientCard) {
        return entityManager.createQuery("SELECT c FROM Contract c WHERE c.patientCard = :patientCard", Contract.class)
                .setParameter("patientCard", patientCard)
                .getResultList();
    }

    public void deletePatientCardIfNotInUse(String passportSeriesNumber) {//проверяем что он не используется в других таблицах
        PatientCard patientCard = findByPassportSeriesNumber(passportSeriesNumber);

        List<Contract> contracts = entityManager.createQuery(
                        "SELECT c FROM Contract c WHERE c.patientCard = :patientCard", Contract.class)
                .setParameter("patientCard", patientCard)
                .getResultList();

        List<Record> records = entityManager.createQuery(
                        "SELECT r FROM Record r WHERE r.patientCard = :patientCard", Record.class)
                .setParameter("patientCard", patientCard)
                .getResultList();

        List<LegalRepresentative> legalRepresentatives = entityManager.createQuery(
                        "SELECT lr FROM LegalRepresentative lr JOIN lr.patientCards pc WHERE pc.passportSeriesNumber = :passportSeriesNumber",
                        LegalRepresentative.class)
                .setParameter("passportSeriesNumber", passportSeriesNumber)
                .getResultList();

        if (contracts.isEmpty() && records.isEmpty() && legalRepresentatives.isEmpty()) {
            entityManager.remove(patientCard);
        } else {
            throw new IllegalStateException("Пациент используется в других таблицах. Невозможно удалить: " + passportSeriesNumber);
        }
    }



}


//    public PatientCard save(PatientCard patientCard) {
//        if (patientCard.getPassportSeriesNumber() == null) {
//            entityManager.persist(patientCard);
//        } else {
//            patientCard = entityManager.merge(patientCard);
//        }
//        return patientCard;
//    }