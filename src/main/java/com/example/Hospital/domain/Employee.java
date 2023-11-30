package com.example.Hospital.domain;

public class Employee {
    private String surname;/*Фамилия сотрудника*/
    private String name;/*Имя*/
    private String patronymic;/*Отчество*/
    private String phoneNumber;/*Номер телефона*/
    private String dateOfBirth;/*Дата рождения*/
    private String passportSeriesNumber;/*Серия и номер паспорта*/
    private String dateOfEmployment;/*Дата приема на работу*/
    private Education education;/*Образование*/
    private Post post;/*Должность*/

    public Employee(String surname, String name, String patronymic, String phoneNumber, String dateOfBirth, String passportSeriesNumber, String dateOfEmployment, Education education, Post post) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.passportSeriesNumber = passportSeriesNumber;
        this.dateOfEmployment = dateOfEmployment;
        this.education = education;
        this.post = post;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassportSeriesNumber() {
        return passportSeriesNumber;
    }

    public void setPassportSeriesNumber(String passportSeriesNumber) {
        this.passportSeriesNumber = passportSeriesNumber;
    }

    public String getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(String dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
