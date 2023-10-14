/*
 This code represents the TwilioConfiguration class, which is a configuration class in a 
 Spring Boot application. This class is used to store configuration parameters necessary 
 for interacting with the Twilio service.
 */
package com.example.twilio.sms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/*
@Configuration: This annotation indicates that the TwilioConfiguration class is a Spring 
configuration class. This means that it provides settings and beans that can be used 
in the application.
 */
@Configuration
public class TwilioConfiguration {
    
    /*
     These annotations are used to embed values from external properties 
     (for example, from the application.properties or application file.yml) 
     to the class fields. The values in {} indicate the property keys to be read. 
     For example, ${account_sib} means that the value for accountSid will be taken from 
     the account_sid property
     */
    @Value("${account_sid}")
    private String accountSid;
    @Value("${auth_token}")
    private String authToken;
    @Value("${trial_number}")
    private String trialNumber;

    public TwilioConfiguration() {

    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getTrialNumber() {
        return trialNumber;
    }

    public void setTrialNumber(String trialNumber) {
        this.trialNumber = trialNumber;
    }
}