package com.sms.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class SmsRequestDto {

    /*
    @NotBlank annotations: These annotations are applied to the phoneNumber and message fields 
    and indicate that they cannot be empty (they should not be null and should not consist 
    only of spaces). These annotations are used to validate data and ensure that when 
    creating a Smsrequest object, these fields will contain non-empty values.
     */

    private String requestId;
    // final, which means that their values cannot be changed after they are set in the constructor.
    @NotBlank
    private String phoneNumber; // destination

    @NotBlank
    private String message;
}