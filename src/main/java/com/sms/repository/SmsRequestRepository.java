package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.entity.SmsRequest;

public interface SmsRequestRepository extends JpaRepository<SmsRequest, Long> {
}