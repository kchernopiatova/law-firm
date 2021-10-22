package com.solvd.lawfirm.structure;

public interface Relocatable {

    void relocate(Building building, String city, String address);

    void changeAddress(Building building, String address);

}
