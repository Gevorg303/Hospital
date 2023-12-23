package com.example.Hospital.controllers;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ModelAndView handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        ModelAndView modelAndView = new ModelAndView("error500");
        modelAndView.addObject("errorMessage", "Ошибка: данное образование используется в таблице сотрудников.");
        return modelAndView;
    }
}