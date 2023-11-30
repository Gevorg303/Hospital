package com.example.Hospital.domain;

public class DayOfWeekAndOpeningHours {
    private String startTime;/*Время начала работы*/
    private String endTimeOfWork;/*Время окончания работы*/

    public DayOfWeekAndOpeningHours(String startTime, String endTimeOfWork) {
        this.startTime = startTime;
        this.endTimeOfWork = endTimeOfWork;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTimeOfWork() {
        return endTimeOfWork;
    }

    public void setEndTimeOfWork(String endTimeOfWork) {
        this.endTimeOfWork = endTimeOfWork;
    }
}
