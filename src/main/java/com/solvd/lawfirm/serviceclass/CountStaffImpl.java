package com.solvd.lawfirm.serviceclass;

import com.solvd.lawfirm.structure.Countable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class CountStaffImpl implements CountStaff {

    private static final Logger LOGGER = LogManager.getLogger(CountStaffImpl.class);

    @Override
    public void countLawyer(Countable countable) {
        Optional<Integer> numberOfLawyers = countable.countLawyers();
        LOGGER.info("Number of lawyers: " + numberOfLawyers.get());
    }
}
