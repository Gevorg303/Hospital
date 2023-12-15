package com.example.Hospital.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;

@Entity
@Table(name = "работник")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @Column(name = "серия_и_номер_паспорта")
    private String passportSeriesNumber;
    @Column(name = "фамилия")
    private String surname;

    @Column(name = "имя")
    private String name;

    @Column(name = "отчество")
    private String patronymic;

    @Column(name = "номер_телефона")
    private String phoneNumber;

    @Column(name = "дата_рождения")
    private LocalDate dateOfBirth;

    @Column(name = "дата_приема_на_работу")
    private LocalDate dateOfEmployment;

    @ManyToOne
    @JoinColumn(name = "идентификатор_образования")
    private Education education;
}