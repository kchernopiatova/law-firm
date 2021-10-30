package com.solvd.lawfirm.serviceclass;

import com.solvd.lawfirm.structure.WeekDay;
import com.solvd.lawfirm.structure.Workable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WorkingCheckImpl implements WorkingCheck {

    private static final Logger LOGGER = LogManager.getLogger(WorkingCheckImpl.class);

    @Override
    public void workingTimeCheck(Workable workable) {
        LOGGER.info("Weekday, working time. Is the office working? " + workable.isWorking(WeekDay.TUESDAY));
        LOGGER.info("Holiday, working time. Is the office working? " + workable.isWorking(true));
        LOGGER.info("Holiday, not working time. Is the office working? " + workable.isWorking(false));
    }
}

