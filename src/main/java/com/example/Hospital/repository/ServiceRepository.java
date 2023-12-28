package com.example.Hospital.repository;

import com.example.Hospital.domain.Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class ServiceRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Service> findAll() {
        return entityManager.createQuery("SELECT s FROM Service s", Service.class)
                .getResultList();
    }

    @Transactional
    public void addService(Service service) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("addservice");
        query.registerStoredProcedureParameter("service_name", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("service_cost", BigDecimal.class, ParameterMode.IN);

        query.setParameter("service_name", service.getName());
        query.setParameter("service_cost", BigDecimal.valueOf(service.getPrice()));

        query.execute();
    }

    @Transactional
    public void deleteService(Service service) {
        entityManager.remove(entityManager.contains(service) ? service : entityManager.merge(service));
    }
}