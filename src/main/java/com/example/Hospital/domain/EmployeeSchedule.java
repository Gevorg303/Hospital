package com.example.Hospital.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;

@Entity
@Table(name = "график_сотрудника")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "идентификатор_графика_сотрудника")
    private Long id;
    @Column(name = "ставка")
    private double bet;
    @Column(name = "дата_назначения")
    private LocalDate dateOfCalculationBid;
    @ManyToOne
    @JoinColumn(name = "идентификатор_графика_работы")
    private WeekDayAndTime weekDayAndTime;
    @Column(name = "серия_и_номер_паспорта_работника")
    private String passportSeriesNumber;
    @ManyToOne
    @JoinColumn(name = "идентификатор_должности")
    private Post post;
}
