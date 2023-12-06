package com.example.Hospital.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "work_schedule")
public class WorkSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "day_of_week_and_opening_hours_id")
    private DayOfWeekAndOpeningHours dayOfWeekAndOpeningHours;

    @Column(name = "bet")
    private int bet;

    @Column(name = "date_of_calculation_bid")
    private String dateOfCalculationBid;
}
