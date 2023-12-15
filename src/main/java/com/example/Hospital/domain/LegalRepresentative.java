package com.example.Hospital.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "законный_представитель")
@AllArgsConstructor
@NoArgsConstructor
public class LegalRepresentative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "идентификатор_законного_представ")
    private Long id;

    @Column(name = "фамилия")
    private String surname;

    @Column(name = "имя")
    private String name;

    @Column(name = "отчество")
    private String patronymic;

    @Column(name = "дата_рождения")
    private LocalDate dateOfBirth;

    @Column(name = "контактный_номер_телефона")
    private String phoneNumber;

    @ManyToMany
    @Column(name = "идентификатор_пациента")
    @JoinTable(
            name = "карточка_пациента_законный_предст",
            joinColumns = @JoinColumn(name = "идентификатор"),
            inverseJoinColumns = @JoinColumn(name = "серия_и_номер_паспорта_пациента")
    )
    private List<PatientCard> patientCards;
}