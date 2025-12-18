package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/risk-scores")
public class RiskScoreController {

    @PostMapping("/evaluate/{visitorId}")
    public ResponseEntity<String> evaluateVisitor(@PathVariable Long visitorId) {
        return ResponseEntity.ok("Risk score evaluated for visitor " + visitorId);
    }

    @GetMapping("/{visitorId}")
    public ResponseEntity<String> getScore(@PathVariable Long visitorId) {
        return ResponseEntity.ok("Risk score for visitor " + visitorId);
    }

    @GetMapping
    public ResponseEntity<String> listScores() {
        return ResponseEntity.ok("List of all risk scores");
    }
}