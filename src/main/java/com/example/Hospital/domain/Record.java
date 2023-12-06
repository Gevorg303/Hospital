package com.example.Hospital.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "record")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_card_id")
    private PatientCard patientCard;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "date_reception")
    private String DateReception;

    @Column(name = "time_reception")
    private String TimeReception;
}