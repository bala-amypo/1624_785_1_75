package com.example.demo.service;

import com.example.demo.entity.RiskScore;
import java.util.List;

public interface RiskScoreService {

    RiskScore evaluateRisk(Long visitorId);

    RiskScore getRiskScoreByVisitor(Long visitorId);

    List<RiskScore> getAllRiskScores();
}
