package com.solvd.lawfirm.service;

import com.solvd.lawfirm.exception.ServiceTimeException;

import java.util.Objects;

public class Service {

    private String serviceTitle;
    private int timeSpent;

    public Service(String serviceTitle, int timeSpent) {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Service service = (Service) obj;
        return Objects.equals(serviceTitle, service.serviceTitle);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((serviceTitle == null) ? 0 : serviceTitle.hashCode());
        return result;
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
