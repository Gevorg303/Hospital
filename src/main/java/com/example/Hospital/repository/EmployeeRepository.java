package com.example.Hospital.repository;

import com.example.Hospital.domain.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Employee> findAll() {
        return entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
    }

    public Employee findByPassportSeriesNumber(String passportSeriesNumber) {
        TypedQuery<Employee> query = entityManager.createQuery(
                        "SELECT e FROM Employee e WHERE e.passportSeriesNumber = :passportSeriesNumber", Employee.class)
                .setParameter("passportSeriesNumber", passportSeriesNumber);

        List<Employee> resultList = query.getResultList();
        return resultList.isEmpty() ? null : resultList.get(0);
    }

    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    public void update(Employee employee) {
        entityManager.merge(employee);
    }

    public void delete(String passportSeriesNumber) {
        Employee employee = findByPassportSeriesNumber(passportSeriesNumber);
        if (employee != null) {
            entityManager.remove(employee);
        }
    }
    public void deleteByPassportSeriesNumber(String passportSeriesNumber) {
        Query query = entityManager.createQuery(
                        "DELETE FROM Employee e WHERE e.passportSeriesNumber = :passportSeriesNumber")
                .setParameter("passportSeriesNumber", passportSeriesNumber);

        query.executeUpdate();
    }
}


