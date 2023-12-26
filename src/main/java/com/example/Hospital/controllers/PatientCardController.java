package com.example.Hospital.controllers;

import com.example.Hospital.domain.PatientCard;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.example.Hospital.services.PatientCardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/patients")
public class PatientCardController {
    @Autowired
    private PatientCardService patientCardService;

    @GetMapping("/patientCardsList")
    public String patientCards(Model model) {
        model.addAttribute("patientCardList", patientCardService.patientCardList());
        return "patients";
    }

    @PostMapping("/patientCard/create")
    public String createPatientCard(
            @NotBlank @ModelAttribute("patientCard") PatientCard patientCard
    )
    {
        patientCardService.savePatientCard(patientCard);
        //redirectAttributes.addFlashAttribute("message", "Patient successfully added");
        return "redirect:/patients/patientCardsList";
    }

    @GetMapping("/patientCard/{passportSeriesNumber}")
    public String patientCardInfo(@PathVariable String passportSeriesNumber, Model model) {
        PatientCard patientCard = patientCardService.getPatientCardByPassportNumber(passportSeriesNumber);
        model.addAttribute("patient", patientCard);
        List<String> floor = Arrays.asList("Мужской", "Женский");
        model.addAttribute("floor", floor);

        return "patientCard-info";
    }


    @PostMapping("/patientCard/edit")
    public String editPatientCard(PatientCard updatedPatientCard, RedirectAttributes redirectAttributes) {
        patientCardService.updatePatientCard(updatedPatientCard);
        redirectAttributes.addFlashAttribute("message", "Patient details updated successfully");
        return "redirect:/patients/patientCardsList";
    }
}

