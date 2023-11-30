package com.example.Hospital.domain;

public class Doctor extends Employee {

    private Record record;/*Записи на прием*/

    public Doctor(String surname, String name, String patronymic, String phoneNumber, String dateOfBirth, String passportSeriesNumber, String dateOfEmployment, Education education, Post post, Record record) {
        super(surname, name, patronymic, phoneNumber, dateOfBirth, passportSeriesNumber, dateOfEmployment, education, post);
        this.record = record;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }
}