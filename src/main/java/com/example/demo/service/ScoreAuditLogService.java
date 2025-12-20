package com.example.demo.service;

import java.util.List;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.ScoreAuditLog;

public interface ScoreAuditLogService {

    ScoreAuditLog logScoreChange(Long visitorId, Long ruleId, ScoreAuditLog log);

    List<ScoreAuditLog> getLogsByVisitor(Long visitorId);

    ScoreAuditLog getLog(Long id);
}
