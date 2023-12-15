package com.example.Hospital.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "день_недели_и_время")
@AllArgsConstructor
@NoArgsConstructor
public class WeekDayAndTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "идентификатор_дня_недели_и_времен")
    private Long id;

    @Column(name = "время_начала_работы")
    private LocalTime startTime;

    @Column(name = "время_окончания_работы")
    private LocalTime endTimeOfWork;

    @ManyToOne
    @JoinColumn(name = "идентификатор_дня_недели")
    private Weekday weekday;

    @ManyToMany(mappedBy = "weekDayAndTimeList")
    private List<WorkSchedule> workSchedules;
}
