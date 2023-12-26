package com.example.Hospital.services;

import com.example.Hospital.domain.DoctorSchedule;
import com.example.Hospital.domain.PatientCard;
import com.example.Hospital.domain.Records;
import com.example.Hospital.repository.DoctorScheduleRepository;
import com.example.Hospital.repository.PatientCardRepository;
import com.example.Hospital.repository.RecordsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordsService {

    @Autowired
    private RecordsRepository recordsRepository;

    public List<Records> getAllRecords() {
        return recordsRepository.getAllRecords();
    }

    @Transactional
    public void addRecord(Records record) {
        recordsRepository.addRecord(record);
    }

    @Transactional
    public void deleteRecord(Long id) {
        recordsRepository.deleteRecord(id);
    }

    public Records findRecordById(Long id) {
        return recordsRepository.findById(id);
    }
}
