package com.example.Hospital.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@Table(name = "специализация")
@AllArgsConstructor
@NoArgsConstructor
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "идентификатор_специализации")
    private Long id;

    @Column(name = "наименование_специализации")
    private String name;

    @Column(name = "описание")
    private String description;

    @Column(name = "коэффицент_к_окладу")
    private double coefficientToSalary;
}