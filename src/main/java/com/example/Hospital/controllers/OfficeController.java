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

        // Инициализируем новый объект Office для формы
        model.addAttribute("newOffice", new Office());

        return "offices";
    }

    @PostMapping("/offices")
    public String addOffice(@ModelAttribute("newOffice") Office newOffice) {
        officeService.saveOffice(newOffice);
        return "redirect:/offices/all";
    }

    @PostMapping("/office/delete/{id}")
    public String deleteOffice(@PathVariable Long id) {
        officeService.deleteOfficeById(id);
        return "redirect:/offices/all";
    }
}
