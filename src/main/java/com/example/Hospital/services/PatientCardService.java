package com.example.Hospital.services;

import com.example.Hospital.domain.PatientCard;
import com.example.Hospital.repository.PatientCardRepository;
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
    public void savePatientCard(PatientCard patientCard){
        log.info("Новый пациент {}", patientCard);
        patientCardRepository.save(patientCard);
    }
    public void deletePatientCard(PatientCard patientCard){
        patientCardRepository.delete(patientCard);
    }
//    public PatientCard getPatientCardById(Long id){
//        return patientCardRepository.findById(id).orElse(null);
//    }
}