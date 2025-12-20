package com.example.demo.service.impl;
import com.example.demo.model.ScoreAuditLog;
import com.example.demo.model.RiskRules;
import com.example.demo.model.Visitor;
import com.example.demo.repository.ScoreAuditLogRepository;
import com.example.demo.repository.RiskRulesRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.ScoreAuditLogService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ScoreAuditLogServiceImpl implements ScoreAuditLogService {
    private final ScoreAuditLogRepository auditLogRepository;
    private final VisitorRepository visitorRepository;
    private final RiskRulesRepository riskRulesRepository;
    public ScoreAuditLogServiceImpl(ScoreAuditLogRepository auditLogRepository,VisitorRepository visitorRepository,RiskRulesRepository riskRulesRepository) {
        this.auditLogRepository = auditLogRepository;
        this.visitorRepository = visitorRepository;
        this.riskRulesRepository = riskRulesRepository;
    }
    @Override
    public ScoreAuditLog logScoreChange(Long visitorId, Long ruleId, ScoreAuditLog log) {
        Visitor visitor = visitorRepository.findById(visitorId).orElse(null);
        RiskRules rule = riskRulesRepository.findById(ruleId).orElse(null);
        log.setVisitor(visitor);
        log.setRiskRule(rule);
        // log.setAppliedRule(rule);
        return auditLogRepository.save(log);
    }
    @Override
    public List<ScoreAuditLog> getLogsByVisitor(Long visitorId) {
        return auditLogRepository.findByVisitorId(visitorId);
    }
    @Override
    public ScoreAuditLog getLog(Long id) {
        return auditLogRepository.findById(id).orElse(null);
    }
}