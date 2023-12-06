package com.example.Hospital.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;
@Entity
@Table(name = "patient_card")
@AllArgsConstructor
@NoArgsConstructor
public class PatientCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "floor")
    private String floor;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "passport_series_number")
    private String passportSeriesNumber;

    @OneToMany(mappedBy = "patientCard")
    private List<Contract> contractList;
}