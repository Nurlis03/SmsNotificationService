package com.example.twilio.sms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@Data
public class SmsRequestDto {

    /*
     @NotBlank annotations: These annotations are applied to the phoneNumber and message fields 
     and indicate that they cannot be empty (they should not be null and should not consist 
     only of spaces). These annotations are used to validate data and ensure that when 
     creating a Smsrequest object, these fields will contain non-empty values.
     */

    // final, which means that their values cannot be changed after they are set in the constructor.
    @NotBlank
    private String phoneNumber; // destination

    @NotBlank
    private String message;
}