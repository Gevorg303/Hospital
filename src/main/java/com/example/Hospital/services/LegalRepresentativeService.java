package com.example.Hospital.services;

import com.example.Hospital.domain.LegalRepresentative;
import com.example.Hospital.repository.LegalRepresentativeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class LegalRepresentativeService {
    @Autowired
    private LegalRepresentativeRepository legalRepresentativeRepository;

    public List<LegalRepresentative> getAllLegalRepresentatives() {
        return legalRepresentativeRepository.findAll();
    }

    public void addLegalRepresentative(LegalRepresentative legalRepresentative) {
        legalRepresentativeRepository.save(legalRepresentative);
    }

    public void deleteLegalRepresentativeById(Long id) {
        legalRepresentativeRepository.deleteById(id);
    }
}