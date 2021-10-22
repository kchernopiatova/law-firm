package com.solvd.lawfirm.cases;

import com.solvd.lawfirm.people.Lawyer;

import java.util.Date;
import java.util.Objects;

public class ClosedCase extends Case implements Comparable<ClosedCase> {

    public static Integer successfulCase = 0;

    private Boolean isSuccessful;
    private Date endingDate;

    public ClosedCase(String type, Lawyer lawyer) {
        super(type, lawyer);
        isSuccessful = true;
        endingDate = new Date();

        successfulCase++;
    }

    public ClosedCase(String type, Lawyer lawyer, boolean isSuccessful) {
        this(type, lawyer);
        this.isSuccessful = isSuccessful;
        endingDate = new Date();

        if (isSuccessful) {
            successfulCase++;
        }
    }

    @Override
    public int compareTo(ClosedCase o) {
        return endingDate.compareTo(o.getEndingDate());
    }

    @Override
    public String toString() {
        return "Ending date: " + endingDate + "; Was the case successful? " + isSuccessful + "; " + super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ClosedCase cases = (ClosedCase) obj;
        return Objects.equals(isSuccessful, cases.isSuccessful) && Objects.equals(endingDate, cases.endingDate)
                && super.equals(obj);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((isSuccessful == null) ? 0 : isSuccessful.hashCode());
        result = prime * result + ((endingDate == null) ? 0 : endingDate.hashCode());
        result += super.hashCode();
        return result;
    }

    public Boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }
}
