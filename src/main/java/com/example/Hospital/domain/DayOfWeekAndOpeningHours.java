package com.example.Hospital.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "day_of_week_and_opening_hours")
public class DayOfWeekAndOpeningHours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time_of_work")
    private String endTimeOfWork;

    @ManyToOne
    @JoinColumn(name = "weekday_id")
    private Weekday weekday;
}