package com.example.Hospital.controllers;

import com.example.Hospital.domain.Employee;
import com.example.Hospital.repository.EducationRepository;
import org.springframework.ui.Model;
import com.example.Hospital.domain.Education;
import com.example.Hospital.services.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/education")
public class EducationController {

    @Autowired
    private EducationService educationService;

    @GetMapping("/list")
    public String educationList(Model model) {
        List<Education> educationList = educationService.getAllEducations();
        model.addAttribute("educationList", educationList);
        return "education";
    }

    @PostMapping("/add")
    public String addEducation(@ModelAttribute("education") Education education) {
        educationService.addEducation(education);
        return "redirect:/education/list";
    }

    @PostMapping("/edit/{id}")
    public String updateEducation(@PathVariable Long id, @ModelAttribute("education") Education education) {
        educationService.updateEducation(id, education);
        return "redirect:/education/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteEducation(@PathVariable Long id) {
        educationService.deleteEducation(id);
        return "redirect:/education/list";
    }
}
