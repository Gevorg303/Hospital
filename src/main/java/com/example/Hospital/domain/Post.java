package com.example.Hospital.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "salary")
    private int salary;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
