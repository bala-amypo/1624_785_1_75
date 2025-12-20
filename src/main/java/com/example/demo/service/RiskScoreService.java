package com.example.demo.service;
import java.util.List;
import com.example.demo.model.RiskScore;
public interface RiskScoreService {
    RiskScore evaluateVisitor(Long visitorId, Integer totalScore);
    RiskScore getRiskScore(Long id);
    List<RiskScore> getAllRiskScores();
    void deleteRiskScore(Long id);
}
