package com.example.Hospital.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;

@Entity
@Table(name = "договор")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "идентификатор_договора")
    private Long id;
    @Column(name = "дата_оформления_договора")
    private LocalDate ContractDormationDate;
    @ManyToOne
    @JoinColumn(name = "идентификатор_законного_представ")
    private LegalRepresentative legalRepresentative;
    @ManyToOne
    @JoinColumn(name = "идентификатор_карточки_пациента")
    private PatientCard patientCard;
}
