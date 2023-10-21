package com.sms.service;

import org.springframework.http.ResponseEntity;

import com.sms.dto.SmsRequestDto;
import com.sms.entity.SmsResponse;

public interface SmsService {
    ResponseEntity<SmsResponse> sendSms(SmsRequestDto smsRequestDto);
}