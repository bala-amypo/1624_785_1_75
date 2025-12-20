package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.VisitLog;
import com.example.demo.service.VisitLogService;

@RestController
@RequestMapping("/api/visit-logs")
public class VisitLogController {

    private final VisitLogService visitLogService;

    // ✅ Constructor injection for test compatibility
    public VisitLogController(VisitLogService visitLogService) {
        this.visitLogService = visitLogService;
    }

    // POST /api/visit-logs/{visitorId}
    @PostMapping("/{visitorId}")
    public ResponseEntity<?> createVisitLog(@PathVariable Long visitorId,
                                            @RequestBody VisitLog log) {
        try {
            VisitLog created = visitLogService.createVisitLog(visitorId, log);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (Exception e) {
            // Tests expect "exitTime must be after entryTime" for invalid times
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // GET /api/visit-logs/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> getLog(@PathVariable Long id) {
        try {
            VisitLog log = visitLogService.getLog(id);
            return ResponseEntity.ok(log);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // GET /api/visit-logs/visitor/{visitorId}
    @GetMapping("/visitor/{visitorId}")
    public ResponseEntity<List<VisitLog>> getLogsByVisitor(@PathVariable Long visitorId) {
        List<VisitLog> logs = visitLogService.getLogsByVisitor(visitorId);
        return ResponseEntity.ok(logs); // returns empty list if none
    }
}
