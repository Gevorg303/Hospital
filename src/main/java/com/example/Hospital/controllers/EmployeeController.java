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
    public String showEmployeeList(Model model) {
        List<Employee> employeeList = employeeService.getAllEmployees();
        model.addAttribute("employeeList", employeeList);

        List<Education> educationList = educationService.getAllEducations();
        model.addAttribute("educationList", educationList);

        model.addAttribute("newEmployee", new Employee());

        return "employee";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute("newEmployee") Employee employee, Model model) {
        try {
            employeeService.addEmployee(employee);
            return "redirect:/employee/list";
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            if (errorMessage.contains("Дата приема на работу должна быть после даты рождения.")) {
                errorMessage = "Дата приема на работу должна быть после даты рождения.";
            } else if (errorMessage.contains("Работнику должно быть 18 лет или старше на момент приема на работу.")) {
                errorMessage = "Работнику должно быть 18 лет или старше на момент приема на работу.";
            }
            model.addAttribute("error", errorMessage);
            List<Employee> employeeList = employeeService.getAllEmployees();
            model.addAttribute("employeeList", employeeList);

            List<Education> educationList = educationService.getAllEducations();
            model.addAttribute("educationList", educationList);

            return "employee";
        }
    }



    @GetMapping("/delete/{passportSeriesNumber}")
    public String deleteEmployee(@PathVariable String passportSeriesNumber) {
        employeeService.deleteEmployee(passportSeriesNumber);
        return "redirect:/employee/list";
    }
}