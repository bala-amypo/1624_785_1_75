package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.ScoreAuditLog;
import com.example.demo.model.RiskRule;
import com.example.demo.model.Visitor;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RiskRuleRepository;
import com.example.demo.repository.ScoreAuditLogRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.ScoreAuditLogService;

@Service
public class ScoreAuditLogServiceImpl implements ScoreAuditLogService {

    @Autowired
    private ScoreAuditLogRepository scoreAuditLogRepository;

    @Autowired
    private VisitorRepository visitorRepository;

    @Autowired
    private RiskRuleRepository riskRuleRepository;

    @Override
    public ScoreAuditLog logScoreChange(Long visitorId, Long ruleId, ScoreAuditLog log) {
        Visitor visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));
        RiskRule rule = riskRuleRepository.findById(ruleId)
                .orElseThrow(() -> new ResourceNotFoundException("RiskRule not found"));
        if (log.getReason() == null || log.getReason().trim().isEmpty()) {
            throw new BadRequestException("reason required");
        }

        log.setVisitor(visitor);
        log.setRule(rule);

        return scoreAuditLogRepository.save(log);
    }

    @Override
    public List<ScoreAuditLog> getLogsByVisitor(Long visitorId) {
        return scoreAuditLogRepository.findByVisitorId(visitorId);
    }

    @Override
    public ScoreAuditLog getLog(Long id) {
        return scoreAuditLogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ScoreAuditLog not found"));
    }
}
