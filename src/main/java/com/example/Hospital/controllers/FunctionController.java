package com.example.Hospital.controllers;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FunctionController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/functionPage")
    public String showFunctionPage(Model model) {
        return "functionPage";
    }

    @GetMapping("/callFunction")
    @ResponseBody
    public String callFunction(Model model) {
        try {
            Integer result = jdbcTemplate.queryForObject("SELECT public.countEmployeesWithHigherEducation()", Integer.class);
            return result != null ? result.toString() : "Ошибка при получении результата";
        } catch (Exception e) {
            return "Ошибка: " + e.getMessage();
        }
    }
    @GetMapping("/numberOfPediatricians")
    @ResponseBody
    public String numberOfPediatricians(Model model) {
        try {
            Integer result = jdbcTemplate.queryForObject("SELECT public.count_pediatricians();", Integer.class);
            return result != null ? result.toString() : "Ошибка при получении результата";
        } catch (Exception e) {
            return "Ошибка: " + e.getMessage();
        }
    }
}
