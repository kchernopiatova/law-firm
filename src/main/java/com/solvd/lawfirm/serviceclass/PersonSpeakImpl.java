package com.solvd.lawfirm.serviceclass;

import com.solvd.lawfirm.people.Speakable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PersonSpeakImpl implements PersonSpeak {

    private static final Logger LOGGER = LogManager.getLogger(PersonSpeakImpl.class);

    @Override
    public void speakTest(Speakable speakable) {
        speakable.sayHB();
        LOGGER.info(speakable.saySmth("The test is successful"));
    }
}
