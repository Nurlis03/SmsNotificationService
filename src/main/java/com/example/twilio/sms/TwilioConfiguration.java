package com.example.twilio.sms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TwilioConfiguration {
    
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