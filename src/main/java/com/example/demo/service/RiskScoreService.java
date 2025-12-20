package com.example.demo.service;

import java.util.List;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.RiskScore;

public interface RiskScoreService {

    RiskScore evaluateVisitor(Long visitorId);

    RiskScore getScoreForVisitor(Long visitorId);

    List<RiskScore> getAllScores();
}
