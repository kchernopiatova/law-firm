package com.solvd.lawfirm.infrastructure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Printer extends Equipment {

    private static final Logger LOGGER = LogManager.getLogger(Printer.class);

    private Boolean colorPrint;

    public Printer(Integer number, Integer price, Boolean colorPrint) {
        super(number, price);
        this.colorPrint = colorPrint;
    }

    @Override
    public void buyEquipment(int amount) {
        LOGGER.info("Buy " + amount + " Printers.");
        number += amount;
    }

    @Override
    public void switchOff() {
        LOGGER.info("The printer switched off");
    }

    @Override
    public void switchOn() {
        LOGGER.info("The printer switched on");
    }

    @Override
    public String toString() {
        return "Pints in color? " + colorPrint + "; " + super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Printer printer = (Printer) obj;
        return Objects.equals(colorPrint, printer.colorPrint) && super.equals(obj);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((colorPrint == null) ? 0 : colorPrint.hashCode());
        result += super.hashCode();
        return result;
    }

    public Boolean getColorPrint() {
        return colorPrint;
    }

    public void setColorPrint(Boolean colorPrint) {
        this.colorPrint = colorPrint;
    }
}
