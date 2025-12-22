package com.example.demo.service.impl;
import com.example.demo.model.RiskRule;
import com.example.demo.model.ScoreAuditLog;
import com.example.demo.model.Visitor;
import com.example.demo.repository.RiskRuleRepository;
import com.example.demo.repository.ScoreAuditLogRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.ScoreAuditLogService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ScoreAuditLogServiceImpl implements ScoreAuditLogService {
    private final ScoreAuditLogRepository logRepository;
    private final VisitorRepository visitorRepository;
    private final RiskRuleRepository ruleRepository;
    public ScoreAuditLogServiceImpl(
            ScoreAuditLogRepository logRepository,
            VisitorRepository visitorRepository,
            RiskRuleRepository ruleRepository) {
        this.logRepository = logRepository;
        this.visitorRepository = visitorRepository;
        this.ruleRepository = ruleRepository;
    }
    @Override
    public ScoreAuditLog addAuditLog(Long visitorId, Long ruleId, ScoreAuditLog log) {
        Visitor visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new RuntimeException("Visitor not found"));
        RiskRule rule = ruleRepository.findById(ruleId)
                .orElseThrow(() -> new RuntimeException("RiskRule not found"));
        log.setVisitor(visitor);
        log.setAppliedRule(rule);

        return logRepository.save(log);
    }
    @Override
    public ScoreAuditLog getAuditLogById(Long id) {
        return logRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("AuditLog not found"));
    }
    @Override
    public List<ScoreAuditLog> getAuditLogsByVisitor(Long visitorId) {
        return logRepository.findByVisitorId(visitorId);
    }
}
