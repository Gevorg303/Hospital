package com.example.Hospital.controllers;

import com.example.Hospital.domain.PatientCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.example.Hospital.services.PatientCardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PatientCardController {
    @Autowired
    private PatientCardService patientCardService;

    @GetMapping("/patientCardsList")
    public String patientCards(Model model) {
        model.addAttribute("patientCardList", patientCardService.patientCardList());
        return "patients";
    }

    @PostMapping("/patientCard/create")
    public String createPatientCard(PatientCard patientCard, RedirectAttributes redirectAttributes){
        patientCardService.savePatientCard(patientCard);
        redirectAttributes.addFlashAttribute("message", "Patient successfully added");
        return "redirect:/patientCardsList";
    }

    @DeleteMapping("/patientCard/delete/{id}")
    public String deletePatientCard(@PathVariable Long id){
        PatientCard patientCard = patientCardService.getPatientCardById(id);
        patientCardService.deletePatientCard(patientCard);
        return "redirect:/patientCardsList";
    }

    @GetMapping("/patientCard/{passportSeriesNumber}")
    public String patientCardInfo(@PathVariable String passportSeriesNumber, Model model) {
        PatientCard patientCard = patientCardService.getPatientCardByPassportNumber(passportSeriesNumber);
        model.addAttribute("patientCard", patientCard);
        return "patientCard-info";
    }




}

