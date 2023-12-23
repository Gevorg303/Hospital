package com.example.Hospital.controllers;

import org.springframework.ui.Model;
import com.example.Hospital.domain.DoctorSchedule;
import com.example.Hospital.services.DoctorScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/doctorSchedules")
public class DoctorScheduleController {
    @Autowired
    private DoctorScheduleService doctorScheduleService;

    @GetMapping("/all")
    public String getAllDoctorSchedules(Model model) {
        List<DoctorSchedule> doctorSchedules = doctorScheduleService.getAllDoctorSchedules();
        model.addAttribute("doctorSchedules", doctorSchedules);
        return "doctorSchedules";
    }

    @PostMapping("/add")
    public String saveDoctorSchedule(DoctorSchedule doctorSchedule, RedirectAttributes redirectAttributes) {
        doctorScheduleService.saveDoctorSchedule(doctorSchedule);
        redirectAttributes.addFlashAttribute("message", "Doctor schedule successfully added");
        return "redirect:/doctorSchedules";
    }

    @PostMapping("/delete/{id}")
    public String deleteDoctorSchedule(@PathVariable Long id) {
        doctorScheduleService.deleteDoctorScheduleById(id);
        return "redirect:/doctorSchedules";
    }
}
