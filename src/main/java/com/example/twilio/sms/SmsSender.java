package com.example.twilio.sms;


import com.example.twilio.sms.dto.SmsRequestDto;

public interface SmsSender {

    void sendSms(SmsRequestDto smsRequestDto);

    // or maybe void sendSms(String phoneNumber, String message);
}