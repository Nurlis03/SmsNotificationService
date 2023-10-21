package com.sms.controller;

import com.sms.service.SmsService;
import com.sms.dto.SmsRequestDto;
import com.sms.entity.SmsResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/sms")
public class SmsController {
    private final SmsService smsService;

    // @Autowired, which means that Spring will automatically create an 
    // instance of Service 
    // and pass it to this controller when it is created.


    // The @Valid annotation indicates the need to validate this object before using it. 
    // @RequestBody specifies that the smsRequest object should be extracted from the request body.
    @PostMapping
    public ResponseEntity<SmsResponse> sendSms(@Valid @RequestBody SmsRequestDto smsRequestDto) {
        return smsService.sendSms(smsRequestDto);
    }
}