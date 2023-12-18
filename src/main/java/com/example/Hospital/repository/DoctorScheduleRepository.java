package com.example.Hospital.repository;

import com.example.Hospital.domain.DoctorSchedule;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class DoctorScheduleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<DoctorSchedule> findAll() {
        return entityManager.createQuery("SELECT ds FROM DoctorSchedule ds", DoctorSchedule.class)
                .getResultList();
    }

    public DoctorSchedule save(DoctorSchedule doctorSchedule) {
        if (doctorSchedule.getId() == null) {
            entityManager.persist(doctorSchedule);
        } else {
            doctorSchedule = entityManager.merge(doctorSchedule);
        }
        return doctorSchedule;
    }

    public void deleteById(Long id) {
        DoctorSchedule doctorSchedule = entityManager.find(DoctorSchedule.class, id);
        if (doctorSchedule != null) {
            entityManager.remove(doctorSchedule);
        }
    }
}