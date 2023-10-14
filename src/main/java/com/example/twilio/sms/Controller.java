package com.example.twilio.sms;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/sms")
public class Controller {

    private final Service service;

    // @Autowired, which means that Spring will automatically create an 
    // instance of Service 
    // and pass it to this controller when it is created.
    @Autowired
    public Controller(Service service) {
        this.service = service;
    }


    // The @Valid annotation indicates the need to validate this object before using it. 
    // @RequestBody specifies that the smsRequest object should be extracted from the request body.
    @PostMapping
    public ResponseEntity<ApiResponse> sendSms(@Valid @RequestBody SmsRequest smsRequest) {
        try {
            service.sendSms(smsRequest);
            ApiResponse response = new ApiResponse(smsRequest.getMessage(), "success", new Date());

            return new ResponseEntity<>(response, HttpStatus.OK); // 200 OK

        } catch (Exception e) {
            ApiResponse errorResponse = new ApiResponse("Failed to send SMS", "error", new Date());
            e.printStackTrace();
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR); // 500 Internal Server Error
        }
    }
}