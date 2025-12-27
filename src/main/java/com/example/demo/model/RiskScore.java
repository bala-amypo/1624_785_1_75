package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RiskScore {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Visitor visitor;

    private Integer totalScore;
    private String riskLevel;
    private LocalDateTime evaluatedAt;

    // ✅ No-args constructor (required by JPA)
    public RiskScore() {
    }

    // ✅ All-args constructor
    public RiskScore(Long id,
                     Visitor visitor,
                     Integer totalScore,
                     String riskLevel,
                     LocalDateTime evaluatedAt) {
        this.id = id;
        this.visitor = visitor;
        this.totalScore = totalScore;
        this.riskLevel = riskLevel;
        this.evaluatedAt = evaluatedAt;
    }

    // ✅ Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public LocalDateTime getEvaluatedAt() {
        return evaluatedAt;
    }

    public void setEvaluatedAt(LocalDateTime evaluatedAt) {
        this.evaluatedAt = evaluatedAt;
    }
}
