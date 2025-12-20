package com.example.demo.controller;
import java.util.List;
import com.example.demo.model.RiskScore;
import com.example.demo.service.RiskScoreService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/risk-scores")
public class RiskScoreController {
    private final RiskScoreService service;
    public RiskScoreController(RiskScoreService service) {
        this.service = service;
    }
    @PostMapping("/evaluate/{visitorId}")
    public RiskScore evaluateVisitor(
            @PathVariable Long visitorId,
            @RequestParam Integer totalScore) {
        return service.evaluateVisitor(visitorId, totalScore);
    }
    @GetMapping("/{id}")
    public RiskScore getRiskScore(@PathVariable Long id) {
        return service.getRiskScore(id);
    }
    @GetMapping
    public List<RiskScore> getAllRiskScores() {
        return service.getAllRiskScores();
    }
    @DeleteMapping("/{id}")
    public void deleteRiskScore(@PathVariable Long id) {
        service.deleteRiskScore(id);
    }
}
