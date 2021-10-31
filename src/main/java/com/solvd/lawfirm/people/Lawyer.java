package com.solvd.lawfirm.people;

import com.solvd.lawfirm.cases.CurrentCase;
import com.solvd.lawfirm.structure.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;

public class Lawyer extends Staff {

    private static final Logger LOGGER = LogManager.getLogger(Lawyer.class);

    private Boolean onWork;
    private Set<Service> service;

    public Lawyer(String firstName, String lastName, LocalDate dob) {
        super(firstName, lastName, dob);
    }

    public Lawyer() {

    }

    public void takeCase(CurrentCase case1, Lawyer lawyer) {
        if (case1.getVacant()) {
            LOGGER.info("The case is taken by " + firstName);
            case1.setVacant(false);
            case1.setLawyer(lawyer);
        } else {
            LOGGER.info("This case is already taken");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " Is Lawyer on work? " + onWork + "; ";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Lawyer lawyer = (Lawyer) obj;
        return Arrays.equals(service.toArray(), lawyer.service.toArray()) && super.equals(obj);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        for (Service service : service) {
            result = prime * result + ((service == null) ? 0 : service.hashCode());
        }
        result += super.hashCode();
        return result;
    }

    public Boolean getOnWork() {
        return onWork;
    }

    public void setOnWork(Boolean onWork) {
        this.onWork = onWork;
    }

    public Set<Service> getService() {
        return service;
    }

    public void setService(Set<Service> service) {
        this.service = service;
    }
}
