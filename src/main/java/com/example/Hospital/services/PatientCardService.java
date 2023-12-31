package com.example.Hospital.services;

import com.example.Hospital.domain.Contract;
import com.example.Hospital.domain.PatientCard;
import com.example.Hospital.repository.PatientCardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PatientCardService {
    @Autowired
    private PatientCardRepository patientCardRepository;

    public List<PatientCard> patientCardList(){
        return patientCardRepository.findAll();
    }

    public void savePatientCard(PatientCard patientCard) {
        patientCardRepository.save(patientCard);
    }
    public PatientCard getPatientCardById(String id){
        return patientCardRepository.findById(id);
    }
    public PatientCard getPatientCardByPassportNumber(String passportSeriesNumber) {
        return patientCardRepository.findByPassportSeriesNumber(passportSeriesNumber);
    }


    @Transactional
    public void updatePatientCard(PatientCard updatedPatientCard) {
        PatientCard existingPatientCard = getPatientCardByPassportNumber(updatedPatientCard.getPassportSeriesNumber());
        if (existingPatientCard != null) {
            existingPatientCard.setSurname(updatedPatientCard.getSurname());
            existingPatientCard.setName(updatedPatientCard.getName());
            existingPatientCard.setPatronymic(updatedPatientCard.getPatronymic());
            existingPatientCard.setFloor(updatedPatientCard.getFloor());
            existingPatientCard.setDateOfBirth(updatedPatientCard.getDateOfBirth());
            existingPatientCard.setPhoneNumber(updatedPatientCard.getPhoneNumber());
            patientCardRepository.save(existingPatientCard);
        } else {
            log.error("Пациент с данным паспортным номером не найден: {}", updatedPatientCard.getPassportSeriesNumber());
        }
    }

}