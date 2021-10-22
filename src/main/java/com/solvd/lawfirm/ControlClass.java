package com.solvd.lawfirm;

import com.solvd.lawfirm.infrastructure.Equipment;

public class ControlClass {

    public static void equipmentPurchase(Equipment equipment, int number) {
        equipment.buyEquipment(number);
    }
}
