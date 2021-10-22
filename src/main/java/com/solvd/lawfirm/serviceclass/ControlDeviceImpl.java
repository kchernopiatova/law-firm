package com.solvd.lawfirm.serviceclass;

import com.solvd.lawfirm.infrastructure.Controllable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ControlDeviceImpl implements ControlDevice {

    private static final Logger LOGGER = LogManager.getLogger(ControlDeviceImpl.class);

    @Override
    public void useEquipment(Controllable controllable) {
        LOGGER.info("Testing of the new equipment ");
        controllable.buyEquipment(1);
        controllable.switchOn();
        controllable.switchOff();
        controllable.repair(true);
    }
}
