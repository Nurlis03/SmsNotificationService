/*
This code represents the TwilioInitializer class, which is a Spring configuration 
class and initializes the Twilio library to interact with the Twilio API.
 */
package com.sms.config;

import com.twilio.Twilio;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class TwilioInitializer {

    /*
    This line defines a static logger using the SLF4J (Simple Logging Facade for Java) library. 
    The logger is used to record messages and information about the progress of the program.
     */

    /*
    This is a class field that represents the Twilio Configuration dependency. 
    This dependency will be implemented into the TwilioInitializer class using the constructor.
     */
    private final TwilioProperties twilioProperties;

    @Autowired
    public TwilioInitializer(TwilioProperties twilioProperties) {
        this.twilioProperties = twilioProperties;
        Twilio.init(
            twilioProperties.getAccountSid(),
            twilioProperties.getAuthToken()
        );
        log.info("Twilio initialized ... with account sid {} ", twilioProperties.getAccountSid());
        log.info("Twilio initialized ... with auth token {} ", twilioProperties.getAuthToken());
        log.info("Twilio initialized ... with trial number {} ", twilioProperties.getTrialNumber());
    }
}