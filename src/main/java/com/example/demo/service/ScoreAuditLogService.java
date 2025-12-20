package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ScoreAuditLog;

public interface ScoreAuditLogService {

    ScoreAuditLog logScoreChange(Long visitorId, Long ruleId, ScoreAuditLog log);

    List<ScoreAuditLog> getLogsByVisitor(Long visitorId);

    ScoreAuditLog getLog(Long id);
}
