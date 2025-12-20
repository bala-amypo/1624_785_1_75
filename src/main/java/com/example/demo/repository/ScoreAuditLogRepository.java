package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ScoreAuditLog;

public interface ScoreAuditLogRepository extends JpaRepository<ScoreAuditLog, Long> {

    List<ScoreAuditLog> findByVisitorId(Long visitorId);
}
