package com.solvd.lawfirm.people;

import com.solvd.lawfirm.exception.InvalidDateException;
import com.solvd.lawfirm.structure.Workable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

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
        LOGGER.info(firstName + " " + lastName + ", Happy people.Birthday!");
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
    public boolean isWorking() {
        LocalDateTime actualTime = LocalDateTime.now();
        return actualTime.getHour() >= 8 && actualTime.getHour() <= 18;
    }

    @Override
    public boolean isWorking(boolean isHoliday) {
        LocalDateTime actualTime = LocalDateTime.now();
        return actualTime.getHour() >= 8 && actualTime.getHour() <= 18 && !isHoliday;
    }

    public double salary(double factor) {
        double initialRate = 1200;
        return initialRate * factor;
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
