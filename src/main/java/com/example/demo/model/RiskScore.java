package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
public class RiskScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Visitor visitor;
    private Integer totalScore;
    private String riskLevel;
    private LocalDateTime evaluatedAt;
    public RiskScore() {
    }
    public RiskScore(Visitor visitor, Integer totalScore) {
        this.visitor = visitor;
        this.totalScore = totalScore;
    }
    @PrePersist
    void calculateRisk() {
        if (totalScore < 0) {
            throw new RuntimeException("Invalid score");
        }
        riskLevel = RiskLevelUtils.determineRiskLevel(totalScore);
        evaluatedAt = LocalDateTime.now();
    }
    public Long getId() {
        return id;
    }
    public Visitor getVisitor() {
        return visitor;
    }
    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }
    public Integer getTotalScore() {
        return totalScore;
    }
    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }
    public String getRiskLevel() {
        return riskLevel;
    }
    public LocalDateTime getEvaluatedAt() {
        return evaluatedAt;
    }
}