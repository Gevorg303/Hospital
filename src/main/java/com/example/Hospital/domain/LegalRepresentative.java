package com.example.Hospital.domain;

public class LegalRepresentative {
    private String surname;/*Фамилия представителя*/
    private String name;/*Имя представителя*/
    private String patronymic;/*Отчество представителя*/
    private String dateOfBirth;/*Дата рождения*/
    private String phoneNumber;/*Контактный номер телефона*/
    private PatientCard ward;/*Подопечный*/
    private Contract contract;/*Договор*/

    public LegalRepresentative(String surname, String name, String patronymic, String dateOfBirth, String phoneNumber, PatientCard ward, Contract contract) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.ward = ward;
        this.contract = contract;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PatientCard getWard() {
        return ward;
    }

    public void setWard(PatientCard ward) {
        this.ward = ward;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
