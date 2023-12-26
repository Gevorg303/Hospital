package com.example.Hospital.repository;

import com.example.Hospital.domain.DoctorSchedule;
import com.example.Hospital.domain.Office;
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

    public DoctorSchedule findById(Long id) {
        return entityManager.find(DoctorSchedule.class, id);
    }

    public void save(DoctorSchedule doctorSchedule) {
        entityManager.persist(doctorSchedule);
    }

    public void deleteById(Long id) {
        DoctorSchedule doctorSchedule = entityManager.find(DoctorSchedule.class, id);
        if (doctorSchedule != null) {
            entityManager.remove(doctorSchedule);
        }
    }
    public boolean isOfficeUsed(Office office) {
        Long count = entityManager.createQuery(
                        "SELECT COUNT(ds) FROM DoctorSchedule ds WHERE ds.office = :office",
                        Long.class)
                .setParameter("office", office)
                .getSingleResult();

        return count != null && count > 0;
    }
}