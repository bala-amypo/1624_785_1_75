package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RiskScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "visitor_id", nullable = false)
    private Visitor visitor;

    private Integer totalScore;

    private String riskLevel;

    private LocalDateTime evaluatedAt;

    @PrePersist
    public void calculateRisk() {
        if (totalScore != null && totalScore < 0) {
            throw new RuntimeException("Invalid score");
        }
        this.riskLevel = RiskLevelUtils.determineRiskLevel(totalScore);
        this.evaluatedAt = LocalDateTime.now();
    }
}
