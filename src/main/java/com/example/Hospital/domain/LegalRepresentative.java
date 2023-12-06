package com.example.Hospital.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "legal_representative")
public class LegalRepresentative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "ward_id")
    private PatientCard ward;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;
}