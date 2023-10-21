package com.sms.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SmsResponseDto {
    private int id;
    private String message;
    private String status;
    private Date date;
}
