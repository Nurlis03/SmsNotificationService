package com.example.twilio.sms;

import com.example.twilio.sms.config.TwilioConfiguration;
import com.example.twilio.sms.dto.SmsRequestDto;
import com.example.twilio.sms.exception.InvalidPhoneNumberException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/*
@Service("twilio"): This annotation indicates that the TwilioSmsSender class is a service that 
is managed by the Spring Framework. The string "twilio" in the annotation indicates the name 
under which this service will be available in the Spring container. This allows you to choose 
between different implementations of the Sms Sender interface, if such implementations exist.
 */
@Slf4j
@Service("twilio")
public class TwilioSmsSender implements SmsSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class);

    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void sendSms(SmsRequestDto smsRequestDto) {
        if (isPhoneNumberValid(smsRequestDto.getPhoneNumber())) {
            PhoneNumber to = new PhoneNumber(smsRequestDto.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
            String message = smsRequestDto.getMessage();
            
            Message.creator(to, from, message).create();
            log.info("");
            LOGGER.info("Send sms {}", smsRequestDto);
        } else {
            throw new InvalidPhoneNumberException(
                    "Phone number [" + smsRequestDto.getPhoneNumber() + "] is not a valid number"
            );
        }

    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        // TODO: Implement phone number validator
        return true;
    }
}