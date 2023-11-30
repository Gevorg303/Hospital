package com.example.Hospital.domain;

public class Specialization {
    private String name;/*Наименование специализации*/
    private String description;/*Описание специализации*/

    public Specialization(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
