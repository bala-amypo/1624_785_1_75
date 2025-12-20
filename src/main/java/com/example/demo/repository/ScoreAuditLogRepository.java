package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.ScoreAuditLog;
public interface ScoreAuditLogRepository extends JpaRepository<ScoreAuditLog, Long> {
}