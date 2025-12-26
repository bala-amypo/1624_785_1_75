package com.example.demo.controller;

import com.example.demo.model.ScoreAuditLog;
import com.example.demo.service.ScoreAuditLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/audit-logs")
@Tag(name = "Audit Logs")
public class ScoreAuditLogController {
    
    private final ScoreAuditLogService scoreAuditLogService;
    
    public ScoreAuditLogController(ScoreAuditLogService scoreAuditLogService) {
        this.scoreAuditLogService = scoreAuditLogService;
    }
    
    @PostMapping("/visitor/{visitorId}/score/{riskScoreId}")
    public ResponseEntity<ScoreAuditLog> create(@PathVariable Long visitorId, @PathVariable Long riskScoreId, @RequestBody ScoreAuditLog log) {
        return ResponseEntity.ok(scoreAuditLogService.logScoreChange(visitorId, riskScoreId, log));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ScoreAuditLog> get(@PathVariable Long id) {
        return ResponseEntity.ok(scoreAuditLogService.getLog(id));
    }
    
    @GetMapping("/visitor/{visitorId}")
    public ResponseEntity<List<ScoreAuditLog>> logsByVisitor(@PathVariable Long visitorId) {
        return ResponseEntity.ok(scoreAuditLogService.getLogsByVisitor(visitorId));
    }
}







// package com.example.demo.controller;
// import com.example.demo.model.ScoreAuditLog;
// import com.example.demo.service.ScoreAuditLogService;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import java.util.List;
// @RestController
// @RequestMapping("/api/audit-logs")
// public class ScoreAuditLogController {
//     private final ScoreAuditLogService service;
//     public ScoreAuditLogController(ScoreAuditLogService service) {
//         this.service = service;
//     }
//     @PostMapping("/{visitorId}/{ruleId}")
//     public ScoreAuditLog addLog(
//             @PathVariable Long visitorId,
//             @PathVariable Long ruleId,
//             @RequestBody ScoreAuditLog log) {
//         return service.addAuditLog(visitorId, ruleId, log);
//     }
//     @GetMapping("/{id}")
//     public ScoreAuditLog getLog(@PathVariable Long id) {
//         return service.getAuditLogById(id);
//     }
//     @GetMapping("/visitor/{visitorId}")
//     public List<ScoreAuditLog> getLogsByVisitor(@PathVariable Long visitorId) {
//         return service.getAuditLogsByVisitor(visitorId);
//     }
// }
