package com.sms.service.impl;

import com.sms.SmsSender;
import com.sms.dto.SmsRequestDto;
import com.sms.entity.SmsRequest;
import com.sms.entity.SmsResponse;
import com.sms.exception.InvalidPhoneNumberException;
import com.sms.repository.SmsRequestRepository;
import com.sms.repository.SmsResponseRepository;
import com.sms.service.SmsService;
import com.twilio.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@RequiredArgsConstructor
@Service
public class SmsServiceImpl implements SmsService {

    private final SmsSender smsSender;
    private final SmsRequestRepository smsRequestRepository;
    private final SmsResponseRepository smsResponseRepository;

    @Override
    public ResponseEntity<SmsResponse> sendSms(SmsRequestDto smsRequestDto) {
        // Save the incoming SMS request
        smsRequestRepository.save(new SmsRequest(smsRequestDto.getPhoneNumber(), smsRequestDto.getMessage()));

        try {
            // Attempt to send the SMS
            smsSender.sendSms(smsRequestDto);
            return createResponse(smsRequestDto.getMessage(), "success", HttpStatus.OK); // 200 OK
        } catch (ApiException | InvalidPhoneNumberException e) {
            // Handle exceptions and create an error response
            return handleException(e);
        }
    }

    // Common method to create an SMS response
    private ResponseEntity<SmsResponse> createResponse(String message, String status, HttpStatus httpStatus) {
        SmsResponse response = new SmsResponse(message, status, new Date());
        smsResponseRepository.save(response);
        return new ResponseEntity<>(response, httpStatus);
    }

    // Common method to handle exceptions
    private ResponseEntity<SmsResponse> handleException(Exception e) {
        e.printStackTrace();
        return createResponse(e.getMessage(), "error", HttpStatus.INTERNAL_SERVER_ERROR); // 500 Internal Server Error
    }
}
