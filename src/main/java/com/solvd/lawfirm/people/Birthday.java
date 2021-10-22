package com.solvd.lawfirm.people;

import java.time.LocalDate;

public class Birthday<T extends Staff> {

    private T person;

    public Birthday(T person) {
        this.person = person;
    }

    public String birthdayPerson(T person) {
        LocalDate currentDate = LocalDate.now();
        if (currentDate.equals(person.getDob())) {
            return "Today is " + person.getFirstName() + "'s people.Birthday!";
        }
        return "Today isn't " + person.getFirstName() + "'s people.Birthday!";
    }

    public T getPerson() {
        return person;
    }

    public void setPerson(T person) {
        this.person = person;
    }
}
