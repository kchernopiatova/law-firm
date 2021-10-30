package com.solvd.lawfirm.people;

import java.time.LocalDate;

public class CEO extends Staff {

    private static CEO instance;

    private CEO(String firstName, String lastName, LocalDate dob) {
        super(firstName, lastName, dob);
    }

    public static CEO createInstance(String firstName, String lastName, LocalDate dob) {
        if (instance == null) {
            instance = new CEO(firstName, lastName, dob);
        }
        return instance;
    }
}
