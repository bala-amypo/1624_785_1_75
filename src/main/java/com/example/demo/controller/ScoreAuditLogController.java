package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/score-logs")
public class ScoreAuditLogController {

    @PostMapping("/{visitorId}/{ruleId}")
    public ResponseEntity<String> createAuditLog(
            @PathVariable Long visitorId,
            @PathVariable Long ruleId) {

        return ResponseEntity.ok(
                "Audit log created for visitor " + visitorId + " and rule " + ruleId);
    }

    @GetMapping("/visitor/{visitorId}")
    public ResponseEntity<String> listLogsForVisitor(@PathVariable Long visitorId) {
        return ResponseEntity.ok("Audit logs for visitor " + visitorId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getAuditLog(@PathVariable Long id) {
        return ResponseEntity.ok("Audit log with id: " + id);
    }
}