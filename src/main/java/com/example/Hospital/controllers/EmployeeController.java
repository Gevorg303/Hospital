package com.example.Hospital.controllers;

import com.example.Hospital.domain.Education;
import com.example.Hospital.services.EducationService;
import org.springframework.ui.Model;
import com.example.Hospital.domain.Employee;
import com.example.Hospital.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EducationService educationService;

    @GetMapping("/list")
    public String employeeList(Model model) {
        List<Employee> employeeList = employeeService.getAllEmployees();
        model.addAttribute("employeeList", employeeList);
        return "employee";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        Education selectedEducation = educationService.getEducationById(employee.getEducation().getId());
        employeeService.addEmployee(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/add")//должен передовать лист с образованиями educationList
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        List<Education> educationList = educationService.getAllEducations();
        model.addAttribute("educationList", educationList);
        return "employee";
    }


    @PostMapping("/edit/{passportSeriesNumber}")
    public String updateEmployee(@PathVariable String passportSeriesNumber, @ModelAttribute("employee") Employee employee) {
        employeeService.updateEmployee(passportSeriesNumber, employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/delete/{passportSeriesNumber}")
    public String deleteEmployee(@PathVariable String passportSeriesNumber) {
        employeeService.deleteEmployee(passportSeriesNumber);
        return "redirect:/employee/list";
    }
}
