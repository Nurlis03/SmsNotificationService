/*
This code represents the TwilioConfiguration class, which is a configuration class in a 
Spring Boot application. This class is used to store configuration parameters necessary 
for interacting with the Twilio service.
 */
package com.sms.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/*
@Configuration: This annotation indicates that the TwilioConfiguration class is a Spring 
configuration class. This means that it provides settings and beans that can be used 
in the application.
 */
@Getter
@Setter
@NoArgsConstructor
@Configuration
public class TwilioProperties {
    
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

}