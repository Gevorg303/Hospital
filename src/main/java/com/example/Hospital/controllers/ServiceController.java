package com.example.Hospital.controllers;

import org.springframework.ui.Model;
import com.example.Hospital.domain.Service;
import com.example.Hospital.services.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/services")
public class ServiceController {
    @Autowired
    private ServicesService servicesService;

    @GetMapping("/all")
    public String getAllServices(Model model) {
        List<Service> services = servicesService.getAllServices();
        model.addAttribute("services", services);
        model.addAttribute("newService", new Service()); // Для добавления новой услуги
        return "services";
    }

    @PostMapping("/add")
    public String addNewService(@ModelAttribute("newService") Service service) {
        servicesService.addNewService(service);
        return "redirect:/services/all";
    }

//    @PostMapping("/delete")
//    public String deleteService(@RequestParam("id") Long id) {
//        servicesService.deleteService(id);
//        return "redirect:/services/all";
//    }
}
