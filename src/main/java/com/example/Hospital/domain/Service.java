package com.example.Hospital.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "услуга")
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "идентификатор_услуги")
    private Long id;

    @Column(name = "наименование_услуги")
    private String name;

    @Column(name = "стоимость")
    private double price;
}