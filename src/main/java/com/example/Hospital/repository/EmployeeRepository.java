package com.example.Hospital.repository;

import com.example.Hospital.domain.Education;
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

    public List<Employee> getAllEmployees() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> rootEntry = cq.from(Employee.class);
        CriteriaQuery<Employee> all = cq.select(rootEntry);
        TypedQuery<Employee> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }
    @Transactional
    public void addEmployee(Employee employee) {
        entityManager.persist(employee);
    }
    @Transactional
    public void deleteEmployee(String passportSeriesNumber) {
        Employee employee = entityManager.find(Employee.class, passportSeriesNumber);
        if (employee != null) {
            entityManager.remove(employee);
        }
    }
}

