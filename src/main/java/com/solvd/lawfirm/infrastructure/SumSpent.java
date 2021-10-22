package com.solvd.lawfirm.infrastructure;

public class SumSpent<E extends Equipment> {

    private E element;

    public SumSpent(E element) {
        this.element = element;
    }

    public <M extends Equipment> Integer calculate() {
        return element.countCost();
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }
}