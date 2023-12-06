package com.example.Hospital.repository.impl;

import com.example.Hospital.domain.PatientCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientCardRepositoryInterface extends JpaRepository<PatientCard, Long> {
    List<PatientCard> findByPatientCard(Long id);
}
