package com.example.Hospital.services;

import com.example.Hospital.domain.Education;
import com.example.Hospital.repository.EducationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EducationService {

    @Autowired
    private EducationRepository educationRepository; // Подставьте ваш репозиторий образования

    public List<Education> getAllEducations() {
        return educationRepository.findAll();
    }

    public Education getEducationById(Long id) {
        return educationRepository.findById(id);
    }

    @Transactional
    public void addEducation(Education education) {
        educationRepository.save(education);
    }

    public void updateEducation(Long id, Education education) {
        Education existingEducation = educationRepository.findById(id);
        if (existingEducation != null) {
            // Обновление данных образования
            existingEducation.setName(education.getName());
            existingEducation.setDescription(education.getDescription());
            educationRepository.save(existingEducation);
        }
    }

    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);
    }
}
