package com.sms.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sms_responses")
@Getter
@Setter
public class SmsResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private String status;
    private Date date;

    public SmsResponse (String message, String status, Date date) {
        this.message = message;
        this.status = status;
        this.date = date;
    }
}