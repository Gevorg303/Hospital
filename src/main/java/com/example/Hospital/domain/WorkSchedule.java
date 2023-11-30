package com.example.Hospital.domain;

public class WorkSchedule {
    private DayOfWeekAndOpeningHours dayOfWeekAndOpeningHours;/*День недели и время работы*/
    private int bet;/*Ставка*/
    private String dateOfCalculationBid;/*Дата исчисления ставки*/

    public WorkSchedule(DayOfWeekAndOpeningHours dayOfWeekAndOpeningHours, int bet, String dateOfCalculationBid) {
        this.dayOfWeekAndOpeningHours = dayOfWeekAndOpeningHours;
        this.bet = bet;
        this.dateOfCalculationBid = dateOfCalculationBid;
    }

    public DayOfWeekAndOpeningHours getDayOfWeekAndOpeningHours() {
        return dayOfWeekAndOpeningHours;
    }

    public void setDayOfWeekAndOpeningHours(DayOfWeekAndOpeningHours dayOfWeekAndOpeningHours) {
        this.dayOfWeekAndOpeningHours = dayOfWeekAndOpeningHours;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public String getDateOfCalculationBid() {
        return dateOfCalculationBid;
    }

    public void setDateOfCalculationBid(String dateOfCalculationBid) {
        this.dateOfCalculationBid = dateOfCalculationBid;
    }
}
