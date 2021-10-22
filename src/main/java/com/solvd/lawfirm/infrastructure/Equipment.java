package com.solvd.lawfirm.infrastructure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public abstract class Equipment implements Controllable {

    private static final Logger LOGGER = LogManager.getLogger(Equipment.class);

    protected Boolean onGuarantee;
    protected Integer number;
    protected Integer price;

    public Equipment(Integer number, Integer price) {
        onGuarantee = false;
        this.number = number;
        this.price = price;
    }

    @Override
    public String toString() {
        return "There is guarantee? " + onGuarantee + "; Number of the equipment: " + number + ";";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Equipment equipment = (Equipment) obj;
        return Objects.equals(onGuarantee, equipment.onGuarantee) && number.equals(equipment.number);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((onGuarantee == null) ? 0 : onGuarantee.hashCode());
        result = prime * result + number;
        return result;
    }

    @Override
    public void repair(boolean broken) {
        if (broken && onGuarantee) {
            LOGGER.info("Equipment is repaired for free");
        } else if (broken && !onGuarantee) {
            LOGGER.info("Repairing will be paid");
        } else {
            LOGGER.info("Equipment isn't broken");
        }
    }

    public abstract void buyEquipment(int number);

    public int countCost() {
        return number * price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getOnGuarantee() {
        return onGuarantee;
    }

    public void setOnGuarantee(Boolean onGuarantee) {
        this.onGuarantee = onGuarantee;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
