package com.solvd.lawfirm.structure;

import com.solvd.lawfirm.exception.ServiceTimeException;

import java.util.Objects;

public enum Service {

    CIVIL("Civil law", 80),
    CRIMINAL("Criminal law", 120),
    INTELLECT("Intellect property", 35);

    private String serviceTitle;
    private int timeSpent;

    Service(String serviceTitle, int timeSpent) {
        this.serviceTitle = serviceTitle;
        if (timeSpent < 0) {
            throw new ServiceTimeException("Incorrect Service time spent");
        }
        this.timeSpent = timeSpent;
    }

    @Override
    public String toString() {
        return "Service title: " + serviceTitle + "; Time spent: " + timeSpent + "; ";
    }

    public String getServiceTitle() {
        return serviceTitle;
    }

    public void setServiceTitle(String serviceTitle) {
        this.serviceTitle = serviceTitle;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(int timeSpent) {
        if (timeSpent < 0) {
            throw new ServiceTimeException("Incorrect Service time spent");
        }
        this.timeSpent = timeSpent;
    }
}
