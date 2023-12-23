package com.example.Hospital.services;

import com.example.Hospital.domain.Specialization;
import com.example.Hospital.repository.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecializationService {
    @Autowired
    private SpecializationRepository specializationRepository;

    public List<Specialization> getAllSpecializations() {
        return specializationRepository.findAllSpecializations();
    }

    public void saveSpecialization(Specialization specialization) {
        specializationRepository.save(specialization);
    }

    public void deleteSpecialization(Long id) {
        specializationRepository.deleteSpecialization(id);
    }

    public void updateSpecialization(Long id, Specialization specialization) {
        Specialization existingSpecialization = specializationRepository.findSpecializationById(id);
        if (existingSpecialization != null) {
            existingSpecialization.setName(specialization.getName());
            existingSpecialization.setDescription(specialization.getDescription());
            existingSpecialization.setCoefficientToSalary(specialization.getCoefficientToSalary());
            specializationRepository.save(existingSpecialization);
        }
    }
}