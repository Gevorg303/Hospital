package com.example.Hospital.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "график_работы")
@AllArgsConstructor
@Data
@Getter
@NoArgsConstructor
public class WorkSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "идентификатор_графика_работы")
    private Long id;
    @Column(name = "описание_графика_работы")
    private String descriptionGraphicWork;
    @ManyToMany
    @JoinTable(
            name = "график_работы_день_неделиивремя",
            joinColumns = @JoinColumn(name = "идентификатор_графика_работы"),
            inverseJoinColumns = @JoinColumn(name = "идентификатор_дня_недели_и_времен")
    )
    private List<WeekDayAndTime> weekDayAndTimeList;
}