package com.example.demo.service;

import com.example.demo.model.RiskScore;
import java.util.List;

public interface RiskScoreService {

    RiskScore evaluateRisk(Long visitorId);

    RiskScore getRiskScoreByVisitor(Long visitorId);

    List<RiskScore> getAllRiskScores();
}
