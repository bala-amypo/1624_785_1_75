package com.example.demo.controller;
import com.example.demo.entity.RiskScore;
import com.example.demo.service.RiskScoreService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/risk-scores")
public class RiskScoreController {

    private final RiskScoreService service;

    public RiskScoreController(RiskScoreService service) {
        this.service = service;
    }

    @PostMapping("/evaluate/{visitorId}")
    public RiskScore evaluateRisk(@PathVariable Long visitorId) {
        return service.evaluateRisk(visitorId);
    }

    @GetMapping("/visitor/{visitorId}")
    public RiskScore getScoreByVisitor(@PathVariable Long visitorId) {
        return service.getRiskScoreByVisitor(visitorId);
    }

    @GetMapping
    public List<RiskScore> getAllScores() {
        return service.getAllRiskScores();
    }
}
