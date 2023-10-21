package com.sms.entity;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "sms_requests")
@Setter
@Getter
@Builder
@AllArgsConstructor
public class SmsRequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String phoneNumber;
    private String message;
}