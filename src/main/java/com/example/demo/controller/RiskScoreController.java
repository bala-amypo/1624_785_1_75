package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.RiskScore;
import com.example.demo.service.RiskScoreService;

@RestController
@RequestMapping("/api/risk-scores")
public class RiskScoreController {

    private final RiskScoreService riskScoreService;

    // ✅ Constructor injection for test compatibility
    public RiskScoreController(RiskScoreService riskScoreService) {
        this.riskScoreService = riskScoreService;
    }

    // POST /api/risk-scores/evaluate/{visitorId}
    @PostMapping("/evaluate/{visitorId}")
    public ResponseEntity<?> evaluateVisitor(@PathVariable Long visitorId) {
        try {
            RiskScore score = riskScoreService.evaluateVisitor(visitorId);
            return ResponseEntity.status(HttpStatus.CREATED).body(score);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // GET /api/risk-scores/{visitorId}
    @GetMapping("/{visitorId}")
    public ResponseEntity<?> getScoreForVisitor(@PathVariable Long visitorId) {
        try {
            RiskScore score = riskScoreService.getScoreForVisitor(visitorId);
            return ResponseEntity.ok(score);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // GET /api/risk-scores
    @GetMapping
    public ResponseEntity<List<RiskScore>> getAllScores() {
        List<RiskScore> scores = riskScoreService.getAllScores();
        return ResponseEntity.ok(scores); // empty list handled by service
    }
}
