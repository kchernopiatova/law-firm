package com.solvd.lawfirm.people;

import com.solvd.lawfirm.exception.InvalidDateException;
import com.solvd.lawfirm.structure.WeekDay;
import com.solvd.lawfirm.structure.Workable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

public class Staff implements Speakable, Workable {

    private static final Logger LOGGER = LogManager.getLogger(Staff.class);

    protected String firstName;
    private String lastName;
    private int experience;
    private LocalDate dob;

    public Staff(String firstName, String lastName, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    public Staff() {

    }

    @Override
    public void sayHB() {
        LOGGER.info(firstName + " " + lastName + ", Happy Birthday!");
    }

    @Override
    public String saySmth(String message) {
        return firstName + " says \"" + message + "\"";
    }

    public double salary() {
        double initialRate = 1200;
        return initialRate;
    }

    @Override
    public String isWorking(WeekDay day) {
        if (WeekDay.SATURDAY.equals(day) || WeekDay.SUNDAY.equals(day)) {
            return "The person isn't working today";
        }
        else {
            return "The person if working today";
        }
    }

    @Override
    public boolean isWorking(boolean isHoliday) {
        LocalDateTime actualTime = LocalDateTime.now();
        return actualTime.getHour() >= 8 && actualTime.getHour() <= 18 && !isHoliday;
    }

    public void salary(Function<Double, Double> function) {
        Double salary = function.apply(1.0);
        LOGGER.info("Initial salary of the staff is: " + salary);
    }

    @Override
    public String toString() {
        return "First name: " + firstName + "; Last name: " + lastName + "; Experience: " +
                experience + "; Date of Birth: " + dob;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Staff staff = (Staff) obj;
        return Objects.equals(firstName, staff.firstName) && Objects.equals(lastName, staff.lastName)
                && Objects.equals(dob, staff.dob);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((dob == null) ? 0 : dob.hashCode());
        return result;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    public void setDob(LocalDate dob) throws InvalidDateException {
        LocalDate currentDate = LocalDate.now();
        if (dob.isAfter(currentDate)) {
            throw new InvalidDateException("Date of Birth is incorrect");
        }
        this.dob = dob;
    }

    public LocalDate getDob() {
        return dob;
    }
}
