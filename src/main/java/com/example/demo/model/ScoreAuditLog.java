package com.example.demo.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
public class ScoreAuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Visitor visitor;
    @ManyToOne
    private RiskRule appliedRule;
    private Integer scoreChange;
    private String reason;
    private LocalDateTime loggedAt;
    public ScoreAuditLog() {
    }
    public ScoreAuditLog(Integer scoreChange, String reason) {
        this.scoreChange = scoreChange;
        this.reason = reason;
    }
    @PrePersist
    void validate() {
        if (scoreChange < 0) {
            throw new RuntimeException("Invalid scoreChange");
        }
        if (reason == null) {
            throw new RuntimeException("reason required");
        }
        loggedAt = LocalDateTime.now();
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
    public RiskRule getAppliedRule() {
        return appliedRule;
    }
    public void setAppliedRule(RiskRule appliedRule) {
        this.appliedRule = appliedRule;
    }
    public Integer getScoreChange() {
        return scoreChange;
    }
    public String getReason() {
        return reason;
    }
    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }
}