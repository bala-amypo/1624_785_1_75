package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.ScoreAuditLog;
import com.example.demo.exception.BadRequestException;
import com.example.demo.service.ScoreAuditLogService;

@RestController
@RequestMapping("/api/score-logs")
public class ScoreAuditLogController {

    private final ScoreAuditLogService scoreAuditLogService;

    // ✅ Constructor injection for test compatibility
    public ScoreAuditLogController(ScoreAuditLogService scoreAuditLogService) {
        this.scoreAuditLogService = scoreAuditLogService;
    }

    // POST /api/score-logs/{visitorId}/{ruleId}
    @PostMapping("/{visitorId}/{ruleId}")
    public ResponseEntity<?> logScoreChange(@PathVariable Long visitorId,
                                            @PathVariable Long ruleId,
                                            @RequestBody ScoreAuditLog log) {
        try {
            ScoreAuditLog created = scoreAuditLogService.logScoreChange(visitorId, ruleId, log);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (BadRequestException e) {
            // Tests expect "reason required" for blank/missing reason
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // GET /api/score-logs/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> getLog(@PathVariable Long id) {
        try {
            ScoreAuditLog log = scoreAuditLogService.getLog(id);
            return ResponseEntity.ok(log);
        } catch (Exception e) {
            // Tests expect exception for missing log (e.g., ID 999)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // GET /api/score-logs/visitor/{visitorId}
    @GetMapping("/visitor/{visitorId}")
    public ResponseEntity<List<ScoreAuditLog>> getLogsByVisitor(@PathVariable Long visitorId) {
        List<ScoreAuditLog> logs = scoreAuditLogService.getLogsByVisitor(visitorId);
        return ResponseEntity.ok(logs); // empty list handled by service
    }
}
