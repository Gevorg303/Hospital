package com.example.Hospital.domain;

public class Post {
    private String name;/*Наименование должности*/
    private String description;/*Описание*/
    private int salary;/*Оклад*/
    private Employee employee;/*Сотрудник*/

    public Post(String name, String description, int salary, Employee employee) {
        this.name = name;
        this.description = description;
        this.salary = salary;
        this.employee = employee;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
