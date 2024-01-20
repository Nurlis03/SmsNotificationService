package com.sms.service.impl;

import com.sms.dto.SmsRequestDto;
import com.sms.entity.SmsRequestEntity;
import com.sms.entity.SmsResponseEntity;
import com.sms.exception.InvalidPhoneNumberException;
import com.sms.repository.SmsRequestRepository;
import com.sms.repository.SmsResponseRepository;
import com.sms.service.SmsSender;
import com.sms.service.SmsService;
import com.twilio.exception.ApiException;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SmsServiceImpl implements SmsService {

    private final SmsSender smsSender;
    private final SmsRequestRepository smsRequestRepository;
    private final SmsResponseRepository smsResponseRepository;

    @Override
    public ResponseEntity<SmsResponseEntity> sendSms(SmsRequestDto smsRequestDto) {
        // Convert the String ID to UUID
        UUID requestId = UUID.fromString(smsRequestDto.getRequestId());
        
        // Save the incoming SMS request
        SmsRequestEntity smsRequestEntity = SmsRequestEntity.builder()
                            .id(requestId)
                            .message(smsRequestDto.getMessage())
                            .phoneNumber(smsRequestDto.getPhoneNumber())
                            .build();

        smsRequestRepository.save(smsRequestEntity);
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
    private ResponseEntity<SmsResponseEntity> createResponse(String message, String status, HttpStatus httpStatus) {
        SmsResponseEntity response = SmsResponseEntity.builder()
                                                      .message(message)
                                                      .status(status)
                                                      .date(new Date())
                                                      .build();
        smsResponseRepository.save(response);

        ResponseEntity<SmsResponseEntity> responseEntity = createResponse(message, status, httpStatus);
        return responseEntity;
    }

    // Common method to handle exceptions
    private ResponseEntity<SmsResponseEntity> handleException(Exception e) {
        e.printStackTrace();
        return createResponse(e.getMessage(), "error", HttpStatus.INTERNAL_SERVER_ERROR); // 500 Internal Server Error
    }
}
