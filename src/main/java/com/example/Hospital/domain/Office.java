package com.example.Hospital.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "кабинет_оказания_услуги")
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "идентификатор_кабинета")
    private Long id;

    @Column(name = "номер_кабинета")
    private int number;

    @Column(name = "наименование_кабинета")
    private String name;
}