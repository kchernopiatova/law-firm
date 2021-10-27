package com.solvd.lawfirm.structure;

import java.util.Objects;

public abstract class Building implements Relocatable, Workable {

    protected String city;
    protected String address;

    public Building(String city, String address) {
        this.city = city;
        this.address = address;
    }

    @Override
    public void relocate(Building building, String city, String address) {
        building.setCity(city);
        building.setAddress(address);
    }

    @Override
    public void changeAddress(Building building, String address) {
        building.setAddress(address);
    }

    @Override
    public String toString() {
        return "The city: " + city + "; The address: " + address + "; ";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Building build = (Building) obj;
        return Objects.equals(city, build.city) && Objects.equals(address, build.address);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        return result;
    }

    public abstract boolean isWorking(boolean isHoliday);

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
