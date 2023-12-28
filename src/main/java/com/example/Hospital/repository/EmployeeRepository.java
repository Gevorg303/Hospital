package com.example.Hospital.repository;

import com.example.Hospital.domain.Education;
import com.example.Hospital.domain.Employee;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("addemployee");
        query.registerStoredProcedureParameter("passport_serial_number", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("last_name", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("first_name", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("middle_name", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("phone_number", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("date_of_birth", LocalDate.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("date_of_employment", LocalDate.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("education_id", Long.class, ParameterMode.IN);

        query.setParameter("passport_serial_number", employee.getPassportSeriesNumber());
        query.setParameter("last_name", employee.getSurname());
        query.setParameter("first_name", employee.getName());
        query.setParameter("middle_name", employee.getPatronymic());
        query.setParameter("phone_number", employee.getPhoneNumber());
        query.setParameter("date_of_birth", employee.getDateOfBirth());
        query.setParameter("date_of_employment", employee.getDateOfEmployment());
        query.setParameter("education_id", employee.getEducation().getId());

        query.execute();
    }
    @Transactional
    public void deleteEmployee(String passportSeriesNumber) {
        Employee employee = entityManager.find(Employee.class, passportSeriesNumber);
        if (employee != null) {
            entityManager.remove(employee);
        }
    }
}

