package com.example.demo.service;
import java.util.List;
import com.example.demo.model.RiskScore;
public interface RiskScoreService {
    RiskScore evaluateVisitor(Long visitorId);
    RiskScore getScoreForVisitor(Long visitorId);
    List<RiskScore> getAllScores();
}