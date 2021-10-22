package com.solvd.lawfirm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Resource implements AutoCloseable {

    private static final Logger LOGGER = LogManager.getLogger(MainClass.class);

    @Override
    public void close() {
        LOGGER.info("Resources are closed");
    }
}
