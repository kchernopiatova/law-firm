package com.solvd.lawfirm.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Connection {

    public static final Logger LOGGER = LogManager.getLogger(Connection.class);

    public void createConnection(){
        LOGGER.info("The connection was created");
        sleep(500);
    }

    public void readConnection(){
        LOGGER.info("The connection was read");
        sleep(500);
    }

    public void updateConnection(){
        LOGGER.info("The connection was updated");
        sleep(500);
    }

    public void deleteConnection(){
        LOGGER.info("The connection was deleted");
        sleep(500);
    }

    public void sleep (long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


