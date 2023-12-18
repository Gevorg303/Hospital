package com.example.Hospital.controllers;

import org.springframework.ui.Model;
import com.example.Hospital.domain.Specialization;
import com.example.Hospital.services.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SpecializationController {
    @Autowired
    private SpecializationService specializationService;

    @GetMapping("/specializations")
    public String getAllSpecializations(Model model) {
        List<Specialization> specializations = specializationService.getAllSpecializations();
        model.addAttribute("specializations", specializations);
        return "specializations";
    }

    @PostMapping("/specializations/add")
    public String addSpecialization(@ModelAttribute Specialization specialization, RedirectAttributes redirectAttributes) {
        specializationService.saveSpecialization(specialization);
        redirectAttributes.addFlashAttribute("message", "Specialization added successfully");
        return "redirect:/specializations";
    }



    @PostMapping("/specializations/delete/{id}")
    public String deleteSpecialization(@PathVariable Long id) {
        specializationService.deleteSpecialization(id);
        return "redirect:/specializations";
    }
}
