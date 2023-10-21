package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.entity.SmsResponseEntity;

public interface SmsResponseRepository extends JpaRepository<SmsResponseEntity, Long> {
}