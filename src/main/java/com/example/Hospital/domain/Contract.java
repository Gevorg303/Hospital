package com.example.Hospital.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Контракт")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_card_id")
    private PatientCard patientCard;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @ManyToOne
    @JoinColumn(name = "legal_representative_id")
    private LegalRepresentative legalRepresentative;
}
