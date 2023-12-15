package com.example.Hospital.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.security.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "врач_со_специализацией_исполняющи")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorWithSpecializationPerformingServiceConsultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "идентификатор_врача_со_специально")
    private Long id;
    @Column(name = "результаты")
    private String results;
    @Column(name = "дата_сдачи_анализа")
    private LocalDate dateOfAnalysis;
    @Column(name = "время_сдачи_анализа")
    private LocalTime timeOfAnalysis;
    @ManyToOne
    @JoinColumn(name = "идентификатор_услуги")
    private Service service;
    @ManyToOne
    @JoinColumn(name = "идентификатор_договора")
    private Contract contract;
    @ManyToOne
    @JoinColumn(name = "идентификатор_графика_врача")
    private DoctorSchedule doctorSchedule;
}
