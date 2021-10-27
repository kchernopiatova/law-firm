package com.solvd.lawfirm.structure;

import com.solvd.lawfirm.exception.EmptyArrayException;
import com.solvd.lawfirm.infrastructure.Equipment;
import com.solvd.lawfirm.people.Lawyer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class Office extends Building implements Countable {

    private LocalDate foundationDate;
    private Map<Integer, Equipment> equipment;
    private Set<Lawyer> lawyer;
    private Set<Department> department;

    public Office(String city, String address, LocalDate foundationDate, Map<Integer, Equipment> equipment,
                  Set<Lawyer> lawyer, Set<Department> department) {
        super(city, address);
        this.foundationDate = foundationDate;
        this.equipment = equipment;
        if (lawyer.size() == 0) {
            throw new EmptyArrayException("The array of lawyers is empty");
        }
        this.lawyer = lawyer;
        if (department.size() == 0) {
            throw new EmptyArrayException("The array of departments is empty");
        }
        this.department = department;
    }

    @Override
    public String toString() {
        StringBuilder eq = new StringBuilder();
        for (Map.Entry<Integer, Equipment> entry : equipment.entrySet()) {
            eq.append("\n").append(entry.toString());
        }

        StringBuilder law = new StringBuilder();
        for (Lawyer value : lawyer) {
            law.append("\n").append(value.toString());
        }

        StringBuilder dep = new StringBuilder();
        for (Department value : department) {
            dep.append("\n").append(value.toString());
        }

        return super.toString() + "\nEquipment:" + eq + "\nLawyers:" + law + "\nDepartments:" + dep;
    }

    @Override
    public int countLawyers() {
        int numberOfLawyers = lawyer.size();
        return numberOfLawyers;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Office office = (Office) obj;
        return Arrays.equals(lawyer.toArray(), office.lawyer.toArray()) && super.equals(obj);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        for (Lawyer value : lawyer) {
            result = prime * result + ((value == null) ? 0 : value.hashCode());
        }
        result += super.hashCode();
        return result;
    }

    @Override
    public String isWorking(WeekDay day) {
        if (day == WeekDay.SATURDAY || day == WeekDay.SUNDAY) {
            return "The office isn't working today";
        }
        else {
            return "The office if working today";
        }
    }

    @Override
    public boolean isWorking(boolean isHoliday) {
        LocalDateTime actualTime = LocalDateTime.now();
        return actualTime.getHour() >= 8 && actualTime.getHour() <= 18 && !isHoliday;
    }

    public LocalDate getFoundationYear() {
        return foundationDate;
    }

    public void setFoundationYear(LocalDate foundationYear) {
        this.foundationDate = foundationYear;
    }

    public Map<Integer, Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(Map<Integer, Equipment> equipment) {
        this.equipment = equipment;
    }

    public Set<Lawyer> getLawyer() {
        return lawyer;
    }

    public void setLawyer(Set<Lawyer> lawyer) {
        this.lawyer = lawyer;
    }

    public Set<Department> getDepartment() {
        return department;
    }

    public void setDepartment(Set<Department> department) {
        this.department = department;
    }
}
