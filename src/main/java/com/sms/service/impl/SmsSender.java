package com.sms.service.impl;


import com.sms.dto.SmsRequestDto;

public interface SmsSender {

    void sendSms(SmsRequestDto smsRequestDto);

    // or maybe void sendSms(String phoneNumber, String message);
}