package com.example.service.Impl;
import com.example.model.ScoreAuditLog;
import com.example.model.RiskRule;
import com.example.model.Visitor;
import com.example.repository.ScoreAuditLogRepository;
import com.example.repository.RiskRuleRepository;
import com.example.repository.VisitorRepository;
import com.example.service.ScoreAuditLogService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ScoreAuditLogServiceImpl implements ScoreAuditLogService {
    private final ScoreAuditLogRepository auditLogRepository;
    private final VisitorRepository visitorRepository;
    private final RiskRuleRepository riskRuleRepository;
    public ScoreAuditLogServiceImpl(ScoreAuditLogRepository auditLogRepository,VisitorRepository visitorRepository,RiskRuleRepository riskRuleRepository) {
        this.auditLogRepository = auditLogRepository;
        this.visitorRepository = visitorRepository;
        this.riskRuleRepository = riskRuleRepository;
    }
    @Override
    public ScoreAuditLog logScoreChange(Long visitorId, Long ruleId, ScoreAuditLog log) {
        Visitor visitor = visitorRepository.findById(visitorId).orElse(null);
        RiskRule rule = riskRuleRepository.findById(ruleId).orElse(null);
        log.setVisitor(visitor);
        log.setRiskRule(rule);
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