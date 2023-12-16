package com.example.Hospital.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "карточка_пациента")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientCard {
    @Id
    @Column(name = "cерия_и_номер_паспорта_пациента")
    private String passportSeriesNumber;

    @Column(name = "фамилия")
    private String surname;

    @Column(name = "имя")
    private String name;

    @Column(name = "отчество")
    private String patronymic;

    @Column(name = "пол")
    private String floor;

    @Column(name = "дата_рождения")
    private LocalDate dateOfBirth;

    @Column(name = "контактный_номер_телефона")
    private String phoneNumber;

    @ManyToMany(mappedBy = "patientCards")
    @Column(name = "идентификатор_законного_представ")
    private List<LegalRepresentative> legalRepresentatives;
}