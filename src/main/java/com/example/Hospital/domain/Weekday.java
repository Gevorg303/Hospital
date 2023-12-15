package com.example.Hospital.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "дни_недели")
@AllArgsConstructor
@NoArgsConstructor
public class Weekday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "идентификатор_дня_недели")
    private Long id;

    @Column(name = "день_недели")
    private String name;
}