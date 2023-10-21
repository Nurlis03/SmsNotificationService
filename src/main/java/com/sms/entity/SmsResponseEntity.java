package com.sms.entity;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "sms_responses")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class SmsResponseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String message;
    private String status;
    private Date date;
}