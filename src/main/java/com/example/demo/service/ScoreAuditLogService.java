package com.example.demo.service;

import com.example.demo.model.ScoreAuditLog;
import java.util.List;

public interface ScoreAuditLogService {
    ScoreAuditLog logScoreChange(Long visitorId, Long riskRuleId, ScoreAuditLog log);

    ScoreAuditLog getLog(Long id);

    List<ScoreAuditLog> getLogsByVisitor(Long visitorId);
}



// package com.example.demo.service;
// import com.example.demo.model.ScoreAuditLog;
// import java.util.List;
// public interface ScoreAuditLogService {
//     ScoreAuditLog addAuditLog(Long visitorId, Long ruleId, ScoreAuditLog log);
//     ScoreAuditLog getAuditLogById(Long id);
//     List<ScoreAuditLog> getAuditLogsByVisitor(Long visitorId);
// }
