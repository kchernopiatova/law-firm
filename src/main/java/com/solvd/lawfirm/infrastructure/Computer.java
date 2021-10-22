package com.solvd.lawfirm.infrastructure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Computer extends Equipment {

    private static final Logger LOGGER = LogManager.getLogger(Computer.class);

    private String type;

    public Computer(Integer number, Integer price, String type) {
        super(number, price);
        this.type = type;
    }

    @Override
    public void buyEquipment(int amount) {
        LOGGER.info("Buy " + amount + " Computer");
        number += amount;
    }

    @Override
    public void switchOff() {
        LOGGER.info("The computer " + type + " switched off");
    }

    @Override
    public void switchOn() {
        LOGGER.info("The computer " + type + " switched on");
    }

    @Override
    public String toString() {
        return "Type: " + type + "; " + super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Computer computer = (Computer) obj;
        return Objects.equals(type, computer.type) && super.equals(obj);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result += super.hashCode();
        return result;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
