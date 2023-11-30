package com.example.Hospital.controllers;

import com.example.Hospital.domain.PatientCard;
import org.springframework.ui.Model;
import com.example.Hospital.services.PatientCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class PatientCardController {
    private final PatientCardService patientCardService;

    @GetMapping("/")
    public String patientCard(Model model){
        model.addAttribute("patientCardList", patientCardService.list());
        return "main";
    }
    @GetMapping("/patientCard/{id}")
    public String patientCardInfo(@PathVariable Long id, Model model){
        PatientCard patientCard = patientCardService.getPatientCardById(id);
        model.addAttribute("patientCard", patientCard);
        return "patientCard-info";
    }

    @PostMapping("/patientCard/create")
    public String createPatientCard(@RequestParam PatientCard patientCard){
        patientCardService.savePatientCard(patientCard);
        return "redirect:/";
    }

    @PostMapping("/patientCard/delete/{id}")
    public String deletePatientCard(@PathVariable Long id){
        patientCardService.deleteProduct(id);
        return "redirect:/";
    }
    //Список договоров: <input type="text" name="contractList[0].fieldName"/>
}
