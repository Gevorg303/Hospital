package com.example.Hospital.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "запись")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Records {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "идентификатор_записи")
    private Long id;
    @Column(name = "дата_приема")
    private LocalDate DateReception;
    @Column(name = "время_приема")
    private LocalTime TimeReception;
    @ManyToOne
    @JoinColumn(name = "идентификатор_графика_врача")
    private DoctorSchedule doctorSchedule;
    @ManyToOne
    @JoinColumn(name = "идентификатор_карточки_пациента")
    private PatientCard patientCard;
}