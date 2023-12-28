package com.example.Hospital.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "должность")
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "идентификатор_должности")
    private Long id;
    @Column(name = "название_должности")
    private String name;
    @Column(name = "оклад")
    private double salary;
    @Column(name = "описание")
    private String description;
}
