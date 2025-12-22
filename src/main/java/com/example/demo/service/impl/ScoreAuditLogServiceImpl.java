// package com.example.demo.service.impl;
// import com.example.demo.model.RiskRule;
// import com.example.demo.model.ScoreAuditLog;
// import com.example.demo.model.Visitor;
// import com.example.demo.repository.RiskRuleRepository;
// import com.example.demo.repository.ScoreAuditLogRepository;
// import com.example.demo.repository.VisitorRepository;
// import com.example.demo.service.ScoreAuditLogService;
// import org.springframework.stereotype.Service;
// import java.util.List;
// @Service
// public class ScoreAuditLogServiceImpl implements ScoreAuditLogService {
//     private final ScoreAuditLogRepository logRepository;
//     private final VisitorRepository visitorRepository;
//     private final RiskRuleRepository ruleRepository;
//     public ScoreAuditLogServiceImpl(
//             ScoreAuditLogRepository logRepository,
//             VisitorRepository visitorRepository,
//             RiskRuleRepository ruleRepository) {
//         this.logRepository = logRepository;
//         this.visitorRepository = visitorRepository;
//         this.ruleRepository = ruleRepository;
//     }
//     @Override
//     public ScoreAuditLog addAuditLog(Long visitorId, Long ruleId, ScoreAuditLog log) {
//         Visitor visitor = visitorRepository.findById(visitorId)
//                 .orElseThrow(() -> new RuntimeException("Visitor not found"));
//         RiskRule rule = ruleRepository.findById(ruleId)
//                 .orElseThrow(() -> new RuntimeException("RiskRule not found"));
//         log.setVisitor(visitor);
//         log.setAppliedRule(rule);

//         return logRepository.save(log);
//     }
//     @Override
//     public ScoreAuditLog getAuditLogById(Long id) {
//         return logRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("AuditLog not found"));
//     }
//     @Override
//     public List<ScoreAuditLog> getAuditLogsByVisitor(Long visitorId) {
//         return logRepository.findByVisitorId(visitorId);
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.model.RiskRule;
import com.example.demo.model.ScoreAuditLog;
import com.example.demo.model.Visitor;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RiskRuleRepository;
import com.example.demo.repository.ScoreAuditLogRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.ScoreAuditLogService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ScoreAuditLogServiceImpl implements ScoreAuditLogService {

    private final ScoreAuditLogRepository auditLogRepository;
    private final VisitorRepository visitorRepository;
    private final RiskRuleRepository riskRuleRepository;

    public ScoreAuditLogServiceImpl(ScoreAuditLogRepository auditLogRepository,
                                    VisitorRepository visitorRepository,
                                    RiskRuleRepository riskRuleRepository) {
        this.auditLogRepository = auditLogRepository;
        this.visitorRepository = visitorRepository;
        this.riskRuleRepository = riskRuleRepository;
    }

    @Override
    public ScoreAuditLog addAuditLog(Long visitorId, Long ruleId, ScoreAuditLog log) {

        if (log.getReason() == null || log.getReason().isEmpty()) {
            throw new BadRequestException("reason required");
        }

        Visitor visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));

        RiskRule rule = riskRuleRepository.findById(ruleId)
                .orElseThrow(() -> new ResourceNotFoundException("Risk rule not found"));

        log.setVisitor(visitor);
        log.setAppliedRule(rule);

        return auditLogRepository.save(log);
    }

    @Override
    public ScoreAuditLog getAuditLogById(Long id) {
        return auditLogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Audit log not found"));
    }

    @Override
    public List<ScoreAuditLog> getAuditLogsByVisitor(Long visitorId) {
        return auditLogRepository.findByVisitorId(visitorId);
    }
}
