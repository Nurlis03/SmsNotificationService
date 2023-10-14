package com.example.twilio.sms.service.impl;

import com.example.twilio.sms.ApiResponse;
import com.example.twilio.sms.dto.SmsRequestDto;
import com.example.twilio.sms.SmsSender;
import com.example.twilio.sms.dto.SmsResponseDto;
import com.example.twilio.sms.service.SMSService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@RequiredArgsConstructor
@Service
public class SMSServiceImpl implements SMSService {

    private final SmsSender smsSender;



    /*
    @Qualifier("twilio") tells Spring to use a bean named "twilio" for embedding.
    This allows you to select a specific implementation of the SmsSender interface
    if there are several implementations of this interface in the application.
     */

    @Override
    public SmsResponseDto sendSms(SmsRequestDto smsRequestDto) {

        try {
            smsSender.sendSms(smsRequestDto);
            ApiResponse response = new ApiResponse(smsRequestDto.getMessage(), "success", new Date());

            return SmsResponseDto.builder().build();


            return new ResponseEntity<>(response, HttpStatus.OK); // 200 OK

        } catch (Exception e) {
            ApiResponse errorResponse = new ApiResponse("Failed to send SMS", "error", new Date());
            e.printStackTrace();
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR); // 500 Internal Server Error
        }
    }
}
