package com.example.Hospital.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "график_работы_день_неделиивремя")
@AllArgsConstructor
@NoArgsConstructor
public class WorkScheduleDayOfTheWeekAndTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "идентификатор_графика_работы_день")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "идентификатор_графика_работы")
    private WorkSchedule workSchedule;

    @ManyToOne
    @JoinColumn(name = "идентификатор_дня_недели_и_времен")
    private WeekDayAndTime weekDayAndTime;
}
