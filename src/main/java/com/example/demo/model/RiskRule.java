package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RiskRules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String ruleName;
    private String ruleType;
    private Integer threshold;
    private Integer scoreImpact;
    private LocalDateTime createdAt;
    @PrePersist
    public void validateAndSetCreatedAt() {
        if (threshold != null && threshold < 0) {
            throw new RuntimeException("Threshold cannot be negative");
        }
        if (scoreImpact != null && scoreImpact < 0) {
            throw new RuntimeException("ScoreImpact cannot be negative");
        }
        this.createdAt = LocalDateTime.now();
    }
}
