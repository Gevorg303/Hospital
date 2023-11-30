package com.example.Hospital.domain;

public class Office {
    private int number;/*Номер кабинета*/
    private String name;/*Наименование*/

    public Office(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
