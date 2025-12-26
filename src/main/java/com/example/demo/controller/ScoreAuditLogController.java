package com.example.demo.controller;

import com.example.demo.model.ScoreAuditLog;
import com.example.demo.service.ScoreAuditLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/files") // Note: Name is generic, but sticking to pattern
@RequiredArgsConstructor
@Tag(name = "ScoreAuditLogController")
public class ScoreAuditLogController {

    private final ScoreAuditLogService scoreAuditLogService;

    @PostMapping("/{visitorId}/{ruleId}")
    public ResponseEntity<ScoreAuditLog> create(@PathVariable Long visitorId, @PathVariable Long ruleId,
            @RequestBody ScoreAuditLog log) {
        return ResponseEntity.ok(scoreAuditLogService.logScoreChange(visitorId, ruleId, log));
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
