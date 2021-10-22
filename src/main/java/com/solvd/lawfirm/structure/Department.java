package com.solvd.lawfirm.structure;

import java.util.Objects;

public class Department {

    private String title;
    private int numberOfEmployee;

    public Department(String title) {
        this.title = title;
        numberOfEmployee = 0;
    }

    @Override
    public String toString() {
        return "Name: " + title + "; Number of employees: " + numberOfEmployee + ";";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Department dep = (Department) obj;
        return Objects.equals(title, dep.title);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfEmployee() {
        return numberOfEmployee;
    }

    public void setNumberOfEmployee(int numberOfEmployee) {
        this.numberOfEmployee = numberOfEmployee;
    }

}
