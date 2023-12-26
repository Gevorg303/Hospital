package com.example.Hospital.services;

import com.example.Hospital.domain.PatientCardLegalRepresentative;
import com.example.Hospital.repository.PatientCardLegalRepresentativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientCardLegalRepresentativeService {
    @Autowired
    private PatientCardLegalRepresentativeRepository repository;

    public List<PatientCardLegalRepresentative> getAllPatientCardLegalRepresentatives() {
        return repository.findAll();
    }

    public PatientCardLegalRepresentative getPatientCardLegalRepresentativeById(Long id) {
        return repository.findById(id);
    }

    public void addPatientCardLegalRepresentative(PatientCardLegalRepresentative patientCardLegalRepresentative) {
        repository.save(patientCardLegalRepresentative);
    }

    public void deletePatientCardLegalRepresentativeById(Long id) {
        repository.deleteById(id);
    }
}