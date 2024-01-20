package com.sms.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.entity.SmsResponseEntity;

public interface SmsResponseRepository extends JpaRepository<SmsResponseEntity, UUID> {
}