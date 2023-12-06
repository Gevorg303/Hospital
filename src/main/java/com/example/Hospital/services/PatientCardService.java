package com.example.Hospital.services;

import com.example.Hospital.domain.Contract;
import com.example.Hospital.domain.PatientCard;
import com.example.Hospital.repository.impl.PatientCardRepositoryInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PatientCardService {
    private final PatientCardRepositoryInterface patientCardRepositoryInterface;
    public List<PatientCard> patientCardList(Long id){
        if(id!=null) return patientCardRepositoryInterface.findByPatientCard(id);
        return patientCardRepositoryInterface.findAll();
    }
    public void savePatientCard(PatientCard patientCard){
        log.info("Новый пациент {}", patientCard);
        patientCardRepositoryInterface.save(patientCard);
    }
    public void deletePatientCard(Long id){
        patientCardRepositoryInterface.deleteById(id);
    }
    public PatientCard getPatientCardById(Long id){
        return patientCardRepositoryInterface.findById(id).orElse(null);
    }
}