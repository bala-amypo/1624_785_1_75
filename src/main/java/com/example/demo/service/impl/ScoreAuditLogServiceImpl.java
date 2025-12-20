package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ScoreAuditLog;
import com.example.demo.entity.RiskRule;
import com.example.demo.entity.Visitor;
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

        // ✅ Ensure visitor exists
        Visitor visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));

        // ✅ Ensure rule exists
        RiskRule rule = riskRuleRepository.findById(ruleId)
                .orElseThrow(() -> new ResourceNotFoundException("RiskRule not found"));

        // ✅ Validate reason
        if (log.getReason() == null || log.getReason().trim().isEmpty()) {
            throw new BadRequestException("reason required");
        }

        log.setVisitor(visitor);
        log.setRule(rule);

        return scoreAuditLogRepository.save(log);
    }

    @Override
    public List<ScoreAuditLog> getLogsByVisitor(Long visitorId) {
        // ✅ Delegates to repository, returns empty list if none
        return scoreAuditLogRepository.findByVisitorId(visitorId);
    }

    @Override
    public ScoreAuditLog getLog(Long id) {
        return scoreAuditLogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ScoreAuditLog not found"));
    }
}
