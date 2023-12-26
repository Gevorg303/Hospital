package com.example.Hospital.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "карточка_пациента_законный_предст")
@AllArgsConstructor
@Getter
@Data
@NoArgsConstructor
public class PatientCardLegalRepresentative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "идентификатор")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "серия_и_номер_паспорта_пациента")
    private PatientCard patientCard;

    @ManyToOne
    @JoinColumn(name = "идентификатор_законного_представ")
    private LegalRepresentative legalRepresentative;
}
