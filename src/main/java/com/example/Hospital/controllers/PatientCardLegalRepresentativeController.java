package com.example.Hospital.controllers;

import org.springframework.ui.Model;
import com.example.Hospital.domain.PatientCardLegalRepresentative;
import com.example.Hospital.services.PatientCardLegalRepresentativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/patientCardLegalRepresentatives")
public class PatientCardLegalRepresentativeController {
    @Autowired
    private PatientCardLegalRepresentativeService service;

    @GetMapping("/list")
    public String getAllPatientCardLegalRepresentatives(Model model) {
        model.addAttribute("patientCardLegalRepresentatives", service.getAllPatientCardLegalRepresentatives());
        return "patient-card-legal-representatives";
    }

    @GetMapping("/delete/{id}")
    public String deletePatientCardLegalRepresentative(@PathVariable Long id) {
        service.deletePatientCardLegalRepresentativeById(id);
        return "redirect:/patientCardLegalRepresentatives/list";
    }

    @PostMapping("/add")
    public String addPatientCardLegalRepresentative(@ModelAttribute PatientCardLegalRepresentative patientCardLegalRepresentative) {
        service.addPatientCardLegalRepresentative(patientCardLegalRepresentative);
        return "redirect:/patientCardLegalRepresentatives/list";
    }
}