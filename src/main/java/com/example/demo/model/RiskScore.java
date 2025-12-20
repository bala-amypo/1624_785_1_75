package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "risk_scores")
public class RiskScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "visitor_id", nullable = false, unique = true)
    private Visitor visitor;

    @Column(nullable = false)
    private Integer totalScore;

    @Column(nullable = false)
    private String riskLevel; 
    // LOW, MEDIUM, HIGH (example values)

    @Column(nullable = false)
    private LocalDateTime evaluatedAt;

    // Constructors
    public RiskScore() {
        this.evaluatedAt = LocalDateTime.now();
    }

    public RiskScore(Visitor visitor, Integer totalScore, String riskLevel) {
        this.visitor = visitor;
        this.totalScore = totalScore;
        this.riskLevel = riskLevel;
        this.evaluatedAt = LocalDateTime.now();
    }

    // Getters and Setters
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

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public LocalDateTime getEvaluatedAt() {
        return evaluatedAt;
    }
}
