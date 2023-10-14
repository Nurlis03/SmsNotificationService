package com.example.twilio.sms.service;

import com.example.twilio.sms.dto.SmsRequestDto;

/*
@org.springframework.stereotype.Service: This annotation indicates that the Service 
class is a Spring component and should be a managed Spring container. 
Thus, Spring will automatically create instances of this class and manage their lifecycle.
 */
public interface SMSService {

    void sendSms(SmsRequestDto smsRequestDto);
}