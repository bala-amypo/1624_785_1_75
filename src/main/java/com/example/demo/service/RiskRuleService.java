package com.example.demo.service;

import java.util.List;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.RiskRule;

public interface RiskRuleService {

    RiskRule createRule(RiskRule rule);

    List<RiskRule> getAllRules();

    RiskRule getRule(Long id);
}
