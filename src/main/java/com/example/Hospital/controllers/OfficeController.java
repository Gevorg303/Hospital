package com.example.Hospital.controllers;

import org.springframework.ui.Model;
import com.example.Hospital.domain.Office;
import com.example.Hospital.services.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class OfficeController {
    @Autowired
    private OfficeService officeService;

    @GetMapping("/offices")
    public String getAllOffices(Model model) {
        List<Office> officeList = officeService.findAllOffices();
        model.addAttribute("officeList", officeList);
        return "offices";
    }

    @PostMapping("/office/create")
    public String createOffice(Office office, RedirectAttributes redirectAttributes) {
        officeService.saveOffice(office);
        redirectAttributes.addFlashAttribute("message", "Office successfully added");
        return "redirect:/offices";
    }

    @DeleteMapping("/office/delete/{id}")
    public String deleteOffice(@PathVariable Long id) {
        officeService.deleteOfficeById(id);
        return "redirect:/offices";
    }


}
