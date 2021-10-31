package com.solvd.lawfirm.structure;

import com.solvd.lawfirm.people.Lawyer;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

public class Court extends Building {

    private String district;
    private int actualCaseNumber;
    private Set<Lawyer> lawyer;

    public Court(String city, String address, String district, int actualCaseNumber, Set<Lawyer> lawyer) {
        super(city, address);
        this.district = district;
        this.actualCaseNumber = actualCaseNumber;
        this.lawyer = lawyer;
    }

    @Override
    public String toString() {
        StringBuilder law = new StringBuilder();
        for (Lawyer value : lawyer) {
            law.append("\n").append(value.toString());
        }
        return super.toString() + "District: " + district + "\nLawyers:" + law;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Court court = (Court) obj;
        return Objects.equals(district, court.district) && super.equals(obj);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((district == null) ? 0 : district.hashCode());
        result += super.hashCode();
        return result;
    }

    @Override
    public String isWorking(WeekDay day) {
        if (WeekDay.SATURDAY.equals(day) || WeekDay.SUNDAY.equals(day)) {
            return "The court isn't working today";
        } else {
            return "The court if working today";
        }
    }

    @Override
    public boolean isWorking(boolean isHoliday) {
        LocalDateTime actualTime = LocalDateTime.now();
        return actualTime.getHour() >= 8 && actualTime.getHour() <= 18 && !isHoliday;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getActualCaseNumber() {
        return actualCaseNumber;
    }

    public void setActualCaseNumber(int actualCaseNumber) {
        this.actualCaseNumber = actualCaseNumber;
    }

    public Set<Lawyer> getStaff() {
        return lawyer;
    }

    public void setStaff(Set<Lawyer> lawyer) {
        this.lawyer = lawyer;
    }
}
