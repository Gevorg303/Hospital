package com.example.Hospital.controllers;

import org.springframework.ui.Model;
import com.example.Hospital.domain.Office;
import com.example.Hospital.services.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/offices")
public class OfficeController {
    @Autowired
    private OfficeService officeService;

    @GetMapping("/all")
    public String getAllOffices(Model model) {
        List<Office> officeList = officeService.findAllOffices();
        model.addAttribute("officeList", officeList);
        model.addAttribute("newOffice", new Office());
        return "offices";
    }

    @PostMapping("/add")
    public String addOffice(@ModelAttribute("newOffice") Office newOffice, RedirectAttributes redirectAttributes) {
        try {
            officeService.saveOffice(newOffice);
            redirectAttributes.addFlashAttribute("message", "Кабинет успешно добавлен");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ошибка при добавлении кабинета: " + e.getMessage());
        }
        return "redirect:/offices/all";
    }

    @PostMapping("/delete/{id}")
    public String deleteOffice(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            officeService.deleteOfficeById(id);
            redirectAttributes.addFlashAttribute("message", "Кабинет успешно удален");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ошибка при удалении кабинета: " + e.getMessage());
        }
        return "redirect:/offices/all";
    }

}

