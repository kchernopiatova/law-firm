package com.solvd.lawfirm.people;

import com.solvd.lawfirm.structure.Court;

import java.time.LocalDate;
import java.util.Objects;

public class Judge extends Staff {

    private Court court;

    public Judge(String firstName, String lastName, LocalDate dob, Court court) {
        super(firstName, lastName, dob);
        this.court = court;
    }

    @Override
    public String toString() {
        return super.toString() + "Court: " + court;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Judge judge = (Judge) obj;
        return Objects.equals(court, judge.court) && super.equals(obj);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((court == null) ? 0 : court.hashCode());
        result += super.hashCode();
        return result;
    }

    @Override
    public double salary(double factor) {
        double initialRate = 1500;
        return initialRate * factor;
    }

    public Court getCourt() {
        return court;
    }

    public void setCourt(Court court) {
        this.court = court;
    }
}
