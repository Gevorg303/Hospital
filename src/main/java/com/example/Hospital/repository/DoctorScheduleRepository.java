package com.example.Hospital.repository;

import com.example.Hospital.domain.DoctorSchedule;
import com.example.Hospital.domain.Office;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
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

    @Transactional
    public void save(DoctorSchedule doctorSchedule) {
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("insert_or_update_schedule");

        storedProcedure.registerStoredProcedureParameter("rate_input", Double.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("appointment_date_input", Date.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("schedule_name_input", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("work_schedule_name_input", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("specialization_name_input", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("office_name_input", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("passport_id_input", String.class, ParameterMode.IN);

        storedProcedure.setParameter("rate_input", doctorSchedule.getBet());
        storedProcedure.setParameter("appointment_date_input", doctorSchedule.getDateOfCalculationBid());
        storedProcedure.setParameter("schedule_name_input", doctorSchedule.getName());
        storedProcedure.setParameter("work_schedule_name_input", doctorSchedule.getWorkSchedule().getDescriptionGraphicWork());
        storedProcedure.setParameter("specialization_name_input", doctorSchedule.getSpecialization().getName());
        storedProcedure.setParameter("office_name_input", doctorSchedule.getOffice().getName());
        storedProcedure.setParameter("passport_id_input", doctorSchedule.getPassportSeriesNumber());

        storedProcedure.execute();
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