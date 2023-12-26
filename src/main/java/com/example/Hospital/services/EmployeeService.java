package com.example.Hospital.services;

import com.example.Hospital.domain.Employee;
import com.example.Hospital.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }
    @Transactional
    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }
    @Transactional
    public void deleteEmployee(String passportSeriesNumber) {
        employeeRepository.deleteEmployee(passportSeriesNumber);
    }
}