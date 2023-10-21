package com.sms.service;

import org.springframework.http.ResponseEntity;

import com.sms.dto.SmsRequestDto;
import com.sms.entity.SmsResponseEntity;

public interface SmsService {
    ResponseEntity<SmsResponseEntity> sendSms(SmsRequestDto smsRequestDto);
}