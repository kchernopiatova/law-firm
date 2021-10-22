package com.solvd.lawfirm.infrastructure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Phone extends Equipment {

    private static final Logger LOGGER = LogManager.getLogger(Phone.class);

    private String pNumber;
    private String brand;

    public Phone(Integer number, Integer price, String pNumber) {
        super(number, price);
        this.pNumber = pNumber;
    }

    @Override
    public void buyEquipment(int amount) {
        LOGGER.info("Buy " + amount + " Phones.");
        number += amount;
    }

    @Override
    public void switchOff() {
        LOGGER.info("The phone " + brand + "  switched off");
    }

    @Override
    public void switchOn() {
        LOGGER.info("The phone " + brand + " switched on");
    }

    @Override
    public String toString() {
        return "Phone number: " + pNumber + "; Brand: " + brand + "; " + super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Phone phone = (Phone) obj;
        return Objects.equals(pNumber, phone.pNumber) && Objects.equals(brand, phone.brand)
                && super.equals(obj);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((pNumber == null) ? 0 : pNumber.hashCode());
        result = prime * result + ((brand == null) ? 0 : brand.hashCode());
        result += super.hashCode();
        return result;
    }

    public String getPhoneNumber() {
        return pNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.pNumber = phoneNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
