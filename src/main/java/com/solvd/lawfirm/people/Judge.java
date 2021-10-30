package com.solvd.lawfirm.people;

import com.solvd.lawfirm.MainClass;
import com.solvd.lawfirm.structure.Court;
import com.solvd.lawfirm.structure.Department;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

public class Judge extends Staff {

    private static final Logger LOGGER = LogManager.getLogger(MainClass.class);

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
    public void salary(Function<Double, Double> function) {
        Double salary = function.apply(1.4);
        LOGGER.info("The salary of Judge is: " + salary);
    }

    public Court getCourt() {
        return court;
    }

    public void setCourt(Court court) {
        this.court = court;
    }
}
