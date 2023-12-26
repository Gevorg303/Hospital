package com.example.Hospital.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;

@Entity
@Table(name = "график_врача")
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "идентификатор_графика_врача")
    private Long id;
    @Column(name = "ставка")
    private double bet;
    @Column(name = "дата_назначения")
    private LocalDate dateOfCalculationBid;
    @ManyToOne
    @JoinColumn(name = "идентификатор_графика_работы")
    private WorkSchedule workSchedule;
    @Column(name = "серия_и_номер_паспорта")
    private String passportSeriesNumber;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "идентификатор_специализации")
    private Specialization specialization;
    @ManyToOne
    @JoinColumn(name = "идентификатор_кабинета_оказания_у")
    private Office office;
}
