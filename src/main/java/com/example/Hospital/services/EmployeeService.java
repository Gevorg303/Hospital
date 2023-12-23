package com.example.Hospital.services;

import com.example.Hospital.domain.Employee;
import com.example.Hospital.repository.EmployeeRepository;
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
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void updateEmployee(String passportSeriesNumber, Employee employee) {
        Employee existingEmployee = employeeRepository.findByPassportSeriesNumber(passportSeriesNumber);
        if (existingEmployee != null) {
            // Обновление данных сотрудника
            existingEmployee.setSurname(employee.getSurname());
            existingEmployee.setName(employee.getName());
            existingEmployee.setPatronymic(employee.getPatronymic());
            existingEmployee.setPhoneNumber(employee.getPhoneNumber());
            existingEmployee.setDateOfBirth(employee.getDateOfBirth());
            existingEmployee.setDateOfEmployment(employee.getDateOfEmployment());
            existingEmployee.setEducation(employee.getEducation());
            employeeRepository.save(existingEmployee);
        }
    }

    public void deleteEmployee(String passportSeriesNumber) {
        employeeRepository.deleteByPassportSeriesNumber(passportSeriesNumber);
    }
}
