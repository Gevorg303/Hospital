package com.example.Hospital.controllers;

import com.example.Hospital.domain.PatientCard;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.example.Hospital.services.PatientCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/patients")
public class PatientCardController {
    @Autowired
    private PatientCardService patientCardService;

    @GetMapping(value = "/all")
    public String patientCards(Model model) {
        model.addAttribute("карточка_пациента", patientCardService.patientCardList());
        return "main";
    }

    @PostMapping("/patientCard/create")
    public String createPatientCard(PatientCard patientCard){
        patientCardService.savePatientCard(patientCard);
        return "redirect:/";
    }

    @PostMapping("/patientCard/delete/{id}")
    public String deletePatientCard(@PathVariable PatientCard patientCard){
        patientCardService.deletePatientCard(patientCard);
        return "redirect:/";
    }

}

//    @GetMapping("/patientCard/{id}")
//    public String patientCardInfo(@PathVariable Long id, Model model){
//        PatientCard patientCard = patientCardService.getPatientCardById(id);
//        model.addAttribute("patientCard", patientCard);
//        return "patientCard-info";
//    }