package com.example.Hospital.services;

import com.example.Hospital.domain.Office;
import com.example.Hospital.repository.DoctorScheduleRepository;
import com.example.Hospital.repository.OfficeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OfficeService {
    @Autowired
    private OfficeRepository officeRepository;
    @Autowired
    private DoctorScheduleRepository doctorScheduleRepository;

    public Office findOfficeById(Long id) {
        return officeRepository.findById(id);
    }

    public List<Office> findAllOffices() {
        return officeRepository.findAll();
    }

    public void deleteOfficeById(Long id) {
        Office office = officeRepository.findById(id);
        if (office != null) {
            boolean isOfficeUsed = doctorScheduleRepository.isOfficeUsed(office);

            if (!isOfficeUsed) {
                officeRepository.delete(office);
            } else {
                log.info("Невозможно удалить кабинет, так как он связан с расписанием врачей.");
            }
        }
    }
    public void saveOffice(Office office) {
        officeRepository.save(office);
    }

}
