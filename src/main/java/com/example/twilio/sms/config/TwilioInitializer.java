/*
This code represents the TwilioInitializer class, which is a Spring configuration 
class and initializes the Twilio library to interact with the Twilio API.
 */
package com.example.twilio.sms.config;

import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioInitializer {

    /*
    This line defines a static logger using the SLF4J (Simple Logging Facade for Java) library. 
    The logger is used to record messages and information about the progress of the program.
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(TwilioInitializer.class);

    /*
    This is a class field that represents the Twilio Configuration dependency. 
    This dependency will be implemented into the TwilioInitializer class using the constructor.
     */
    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioInitializer(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
        Twilio.init(
                twilioConfiguration.getAccountSid(),
                twilioConfiguration.getAuthToken()
        );
        LOGGER.info("Twilio initialized ... with account sid {} ", twilioConfiguration.getAccountSid());
        LOGGER.info("Twilio initialized ... with auth token {} ", twilioConfiguration.getAuthToken());
        LOGGER.info("Twilio initialized ... with trial number {} ", twilioConfiguration.getTrialNumber());
    }
}