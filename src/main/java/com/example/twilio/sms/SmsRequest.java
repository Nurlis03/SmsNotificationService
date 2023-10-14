package com.example.twilio.sms;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

public class SmsRequest {

    /*
     @NotBlank annotations: These annotations are applied to the phoneNumber and message fields 
     and indicate that they cannot be empty (they should not be null and should not consist 
     only of spaces). These annotations are used to validate data and ensure that when 
     creating a Smsrequest object, these fields will contain non-empty values.
     */

    // final, which means that their values cannot be changed after they are set in the constructor.
    @NotBlank
    private final String phoneNumber; // destination

    @NotBlank
    private final String message;

    /*
    @JsonProperty specifies which JSON field names should be associated with constructor 
    arguments. This is useful when deserializing JSON objects when the names of JSON 
    fields do not match the names of constructor arguments.
     */
    public SmsRequest(@JsonProperty("phoneNumber") String phoneNumber,
                      @JsonProperty("message") String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "SmsRequest{" +
                "phoneNumber= ..." + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}