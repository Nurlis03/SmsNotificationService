package com.example.twilio.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/*
@org.springframework.stereotype.Service: This annotation indicates that the Service 
class is a Spring component and should be a managed Spring container. 
Thus, Spring will automatically create instances of this class and manage their lifecycle.
 */
@org.springframework.stereotype.Service
public class Service {

    private final SmsSender smsSender;

    /*
    @Qualifier("twilio") tells Spring to use a bean named "twilio" for embedding. 
    This allows you to select a specific implementation of the SmsSender interface 
    if there are several implementations of this interface in the application.
     */
    @Autowired
    public Service(@Qualifier("twilio") TwilioSmsSender smsSender) {
        this.smsSender = smsSender;
    }

    public void sendSms(SmsRequest smsRequest) {
        smsSender.sendSms(smsRequest);
    }
}