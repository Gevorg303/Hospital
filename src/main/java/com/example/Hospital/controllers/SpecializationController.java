package com.example.Hospital.controllers;

import org.springframework.ui.Model;
import com.example.Hospital.domain.Specialization;
import com.example.Hospital.services.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/specializations")
public class SpecializationController {
    @Autowired
    private SpecializationService specializationService;

    @GetMapping("/all")
    public String getAllSpecializations(Model model) {
        List<Specialization> specializations = specializationService.getAllSpecializations();
        model.addAttribute("specializations", specializations);
        return "specializations";
    }

    @PostMapping("/add")
    public String addSpecialization(@ModelAttribute Specialization specialization) {
        specializationService.saveSpecialization(specialization);
        return "redirect:/specializations/all";
    }

    @PostMapping("/delete/{id}")
    public String deleteSpecialization(@PathVariable Long id) {
        specializationService.deleteSpecialization(id);
        return "redirect:/specializations/all";
    }

    @PostMapping("/edit/{id}")
    public String editSpecialization(@PathVariable Long id, @ModelAttribute Specialization specialization) {
        specializationService.updateSpecialization(id, specialization);
        return "redirect:/specializations/all";
    }
}
