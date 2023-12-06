package com.example.Hospital.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "weekday")
public class Weekday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
}