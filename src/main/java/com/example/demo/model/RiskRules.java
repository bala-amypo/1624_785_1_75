package com.example.demo.model;

import jakarta.persistence.*en;
import java.time.LocalDateTime;
@Entity
public class RiskRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String ruleName;

    private String ruleType;
    private Integer threshold;
    private Integer scoreImpact;
    private LocalDateTime createdAt;

    public RiskRule() {
    }

    public RiskRule(String ruleName, String ruleType, Integer threshold, Integer scoreImpact) {
        this.ruleName = ruleName;
        this.ruleType = ruleType;
        this.threshold = threshold;
        this.scoreImpact = scoreImpact;
    }

    @PrePersist
    void validate() {
        if (threshold < 0 || scoreImpact < 0) {
            throw new RuntimeException("Invalid threshold or scoreImpact");
        }
        createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public String getRuleType() {
        return ruleType;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public Integer getScoreImpact() {
        return scoreImpact;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}