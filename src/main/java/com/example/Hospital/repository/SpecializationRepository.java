package com.example.Hospital.repository;

import com.example.Hospital.domain.Specialization;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Transactional
public class SpecializationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Specialization> findAllSpecializations() {
        return entityManager.createQuery("SELECT s FROM Specialization s", Specialization.class)
                .getResultList();
    }

    @Transactional
    public void save(Specialization specialization) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("addspecialization");
        query.registerStoredProcedureParameter("specialization_name", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("specialization_description", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("salary_coefficient", BigDecimal.class, ParameterMode.IN);

        query.setParameter("specialization_name", specialization.getName());
        query.setParameter("specialization_description", specialization.getDescription());
        query.setParameter("salary_coefficient", BigDecimal.valueOf(specialization.getCoefficientToSalary()));

        query.execute();
    }

    public void deleteSpecialization(Long id) {
        Specialization specialization = findSpecializationById(id);
        if (specialization != null) {
            entityManager.remove(specialization);
        }
    }

    public Specialization findSpecializationById(Long id) {
        return entityManager.find(Specialization.class, id);
    }
}
