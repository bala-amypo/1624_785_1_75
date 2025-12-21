package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.ScoreAuditLog;

import java.util.List;

public interface ScoreAuditLogRepository extends JpaRepository<ScoreAuditLog, Long> {

    List<ScoreAuditLog> findByVisitorId(Long visitorId);
}
