package com.example.Hospital.services;

import com.example.Hospital.domain.DoctorSchedule;
import com.example.Hospital.domain.Office;
import com.example.Hospital.repository.DoctorScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DoctorScheduleService {

    @Autowired
    private DoctorScheduleRepository doctorScheduleRepository;

    public List<DoctorSchedule> getAllDoctorSchedules() {
        return doctorScheduleRepository.findAll();
    }

    public DoctorSchedule getDoctorScheduleById(Long id) {
        return doctorScheduleRepository.findById(id);
    }

    public void addDoctorSchedule(DoctorSchedule doctorSchedule) {
        doctorScheduleRepository.save(doctorSchedule);
    }

    public void deleteDoctorScheduleById(Long id) {
        doctorScheduleRepository.deleteById(id);
    }

    public boolean isOfficeUsed(Office office) {
        return doctorScheduleRepository.isOfficeUsed(office);
    }
}
