package com.solvd.lawfirm.cases;

import com.solvd.lawfirm.people.Lawyer;

import java.util.Objects;

public class Case {

    private String type;
    private Lawyer lawyer;

    public Case(String type, Lawyer lawyer) {
        this.type = type;
        this.lawyer = lawyer;
    }

    public Case() {

    }

    @Override
    public String toString() {
        return "Type of case: " + type + "; \nLawyer: \n" + lawyer.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Case cases = (Case) obj;
        return Objects.equals(type, cases.type) && Objects.equals(lawyer, cases.lawyer);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((lawyer == null) ? 0 : lawyer.hashCode());
        return result;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Lawyer getLawyer() {
        return lawyer;
    }

    public void setLawyer(Lawyer lawyer) {
        this.lawyer = lawyer;
    }
}
