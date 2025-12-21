package com.example.demo.service;

import com.example.demo.entity.ScoreAuditLog;
import java.util.List;

public interface ScoreAuditLogService {

    ScoreAuditLog addAuditLog(Long visitorId, Long ruleId, ScoreAuditLog log);

    ScoreAuditLog getAuditLogById(Long id);

    List<ScoreAuditLog> getAuditLogsByVisitor(Long visitorId);
}
