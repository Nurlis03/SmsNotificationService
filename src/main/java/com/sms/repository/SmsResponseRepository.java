package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.entity.SmsResponse;

public interface SmsResponseRepository extends JpaRepository<SmsResponse, Long> {
}