package com.example.twilio.sms.controller;

import com.example.twilio.sms.exception.InvalidPhoneNumberException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class AdviceController {

    @ExceptionHandler({InvalidPhoneNumberException.class})
    public ResponseEntity<Object> handleException(InvalidPhoneNumberException exception) {

        log.error(exception.toString());
        return ResponseEntity.badRequest().body(exception.getMessage());
        //
    }
}
