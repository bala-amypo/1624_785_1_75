package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "risk_rules")
public class RiskRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String ruleName;

    @Column(nullable = false)
    private String ruleType; 
    // AFTER_HOURS, FREQUENT_VISITS, BLACKLIST, KEYWORD, CUSTOM

    private Integer threshold;

    @Column(nullable = false)
    private Integer scoreImpact;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    // Constructors
    public RiskRule() {
        this.createdAt = LocalDateTime.now();
    }

    public RiskRule(String ruleName, String ruleType, Integer threshold, Integer scoreImpact) {
        this.ruleName = ruleName;
        this.ruleType = ruleType;
        this.threshold = threshold;
        this.scoreImpact = scoreImpact;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public Integer getScoreImpact() {
        return scoreImpact;
    }

    public void setScoreImpact(Integer scoreImpact) {
        this.scoreImpact = scoreImpact;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
