package com.example.Hospital.domain;

import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
public class PatientCard {
    private long id;
    private String surname;/*Фамилия пациента*/
    private String name;/*Имя*/
    private String patronymic;/*Отчество*/
    private String floor;/*Пол*/
    private String dateOfBirth;/*Дата рождения*/
    private String phoneNumber;/*Контактный номер телефона*/
    private String passportSeriesNumber;/*Серия и номер паспорта*/
    //private List<Contract> contractList;/*Список договоров*/
}
