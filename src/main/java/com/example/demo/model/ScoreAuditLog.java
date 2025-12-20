package com.example.demo.model;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScoreAuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "visitor_id", nullable = false)
    private Visitor visitor;
    @OneToOne
    @JoinColumn(name = "risk_rule_id")
    private RiskRule appliedRule;
    private Integer scoreChange;
    private String reason;
    private LocalDateTime loggedAt;
    @PrePersist
    public void validate() {
        if (scoreChange != null && scoreChange < 0) {
            throw new RuntimeException("Invalid scoreChange");
        }
        if (reason == null || reason.isBlank()) {
            throw new RuntimeException("reason required");
        }
        this.loggedAt = LocalDateTime.now();
    }
}
