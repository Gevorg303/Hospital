package com.example.Hospital.services;

import com.example.Hospital.domain.DoctorSchedule;
import com.example.Hospital.repository.DoctorScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DoctorScheduleService {
    @Autowired
    private DoctorScheduleRepository doctorScheduleRepository;

    public List<DoctorSchedule> getAllDoctorSchedules() {
        return doctorScheduleRepository.findAll();
    }

    public DoctorSchedule saveDoctorSchedule(DoctorSchedule doctorSchedule) {
        return doctorScheduleRepository.save(doctorSchedule);
    }

    public void deleteDoctorScheduleById(Long id) {
        doctorScheduleRepository.deleteById(id);
    }
}
