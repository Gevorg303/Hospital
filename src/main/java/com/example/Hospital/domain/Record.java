package com.example.Hospital.domain;

public class Record {
    private PatientCard patientCard;/*Пациент*/
    private Doctor doctor;/*Врач проводящий прием*/
    private String DateReception;/*Дата приема*/
    private String TimeReception;/*Время приема*/

    public Record(PatientCard patientCard, Doctor doctor, String dateReception, String timeReception) {
        this.patientCard = patientCard;
        this.doctor = doctor;
        DateReception = dateReception;
        TimeReception = timeReception;
    }

    public PatientCard getPatientCard() {
        return patientCard;
    }

    public void setPatientCard(PatientCard patientCard) {
        this.patientCard = patientCard;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getDateReception() {
        return DateReception;
    }

    public void setDateReception(String dateReception) {
        DateReception = dateReception;
    }

    public String getTimeReception() {
        return TimeReception;
    }

    public void setTimeReception(String timeReception) {
        TimeReception = timeReception;
    }
}