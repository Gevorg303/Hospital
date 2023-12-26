package com.example.Hospital.controllers;

import org.springframework.ui.Model;
import com.example.Hospital.domain.DoctorSchedule;
import com.example.Hospital.services.DoctorScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/doctorSchedules")
public class DoctorScheduleController {
    @Autowired
    private DoctorScheduleService doctorScheduleService;

    @GetMapping("/list")
    public String showDoctorSchedules(Model model) {
        List<DoctorSchedule> doctorSchedules = doctorScheduleService.getAllDoctorSchedules();
        model.addAttribute("doctorSchedules", doctorSchedules);
        model.addAttribute("newDoctorSchedule", new DoctorSchedule());
        return "doctorSchedules";
    }

    @PostMapping("/add")
    public String addDoctorSchedule(@ModelAttribute("newDoctorSchedule") DoctorSchedule doctorSchedule, Model model) {
        try {
            doctorScheduleService.addDoctorSchedule(doctorSchedule);
            return "redirect:/doctorSchedules/list";
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            if (errorMessage.contains("Врачам со специализацией \"Хирург\" необходимо иметь высшее образование.")) {
                errorMessage = "Врачам со специализацией \"Хирург\" необходимо иметь высшее образование.";
            }
            model.addAttribute("error", errorMessage);
            model.addAttribute("doctorSchedules", doctorScheduleService.getAllDoctorSchedules());
            return "doctorSchedules";
        }
    }


    @GetMapping("/delete/{id}")
    public String deleteDoctorSchedule(@PathVariable Long id) {
        doctorScheduleService.deleteDoctorScheduleById(id);
        return "redirect:/doctorSchedules/list";
    }
}
