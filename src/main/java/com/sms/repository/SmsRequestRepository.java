package com.sms.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.entity.SmsRequestEntity;

public interface SmsRequestRepository extends JpaRepository<SmsRequestEntity, UUID> {
}