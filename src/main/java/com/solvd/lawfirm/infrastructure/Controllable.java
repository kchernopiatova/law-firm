package com.solvd.lawfirm.infrastructure;

public interface Controllable {

    void buyEquipment(int number);

    void switchOff();

    void switchOn();

    void repair(boolean broken);

}
