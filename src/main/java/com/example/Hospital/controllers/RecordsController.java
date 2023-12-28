package com.example.Hospital.controllers;

import com.example.Hospital.domain.Records;
import com.example.Hospital.services.RecordsService;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/records")
public class RecordsController {
    @Autowired
    private RecordsService recordsService;

    @GetMapping("/list")
    public String showRecords(Model model) {
        List<Records> recordsList = recordsService.getAllRecords();
        model.addAttribute("recordsList", recordsList);
        model.addAttribute("newRecord", new Records());
        return "records";
    }

    @PostMapping("/add")
    public String addRecord(@ModelAttribute Records record, Model model) {
        try {
            recordsService.addRecord(record);
            return "redirect:/records/list";
        } catch (Exception e) {
            String errorMessage = "Произошла ошибка при добавлении записи на прием.";

            if (e.getMessage() != null && e.getMessage().contains("Невозможно добавить запись на прием. У пациента нет карточки.")) {
                errorMessage = "Невозможно добавить запись на прием. У пациента нет карточки.";
            } else if (e.getMessage() != null && e.getMessage().contains("Нельзя записаться на дату и время до текущей даты и времени")) {
                errorMessage = "Нельзя записаться на дату и время до текущей даты и времени";
            }

            model.addAttribute("error", errorMessage);
            model.addAttribute("recordsList", recordsService.getAllRecords());
            model.addAttribute("newRecord", record);
            return "records";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteRecord(@PathVariable Long id) {
        recordsService.deleteRecord(id);
        return "redirect:/records/list";
    }
}