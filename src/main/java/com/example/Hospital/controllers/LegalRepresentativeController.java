package com.example.Hospital.controllers;

import org.springframework.ui.Model;
import com.example.Hospital.domain.LegalRepresentative;
import com.example.Hospital.services.LegalRepresentativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/legalRepresentatives")
public class LegalRepresentativeController {
    @Autowired
    private LegalRepresentativeService legalRepresentativeService;

    @GetMapping("/list")
    public String showLegalRepresentatives(Model model) {
        model.addAttribute("legalRepresentatives", legalRepresentativeService.getAllLegalRepresentatives());
        return "legalRepresentatives";
    }
    @PostMapping("/add")
    public String addLegalRepresentative(@ModelAttribute LegalRepresentative legalRepresentative, Model model) {
        try {
            legalRepresentativeService.addLegalRepresentative(legalRepresentative);
            return "redirect:/legalRepresentatives/list";
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            if (errorMessage.contains("ОШИБКА: Возраст законного представителя должен быть 18 лет или старше.")) {
                errorMessage = "Возраст законного представителя должен быть 18 лет или старше.";
            }
            model.addAttribute("error", errorMessage);
            model.addAttribute("legalRepresentatives", legalRepresentativeService.getAllLegalRepresentatives());
            return "legalRepresentatives";
        }
    }
    @GetMapping("/delete/{id}")
    public String deleteLegalRepresentative(@PathVariable Long id) {
        legalRepresentativeService.deleteLegalRepresentativeById(id);
        return "redirect:/legalRepresentatives/list";
    }
}

