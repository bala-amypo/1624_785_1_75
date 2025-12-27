package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ScoreAuditLog {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Visitor visitor;

    @ManyToOne
    private RiskRule appliedRule;

    private Integer scoreChange;
    private String reason;
    private LocalDateTime loggedAt;

    // ✅ No-args constructor (required by JPA)
    public ScoreAuditLog() {
    }

    // ✅ All-args constructor
    public ScoreAuditLog(Long id,
                         Visitor visitor,
                         RiskRule appliedRule,
                         Integer scoreChange,
                         String reason,
                         LocalDateTime loggedAt) {
        this.id = id;
        this.visitor = visitor;
        this.appliedRule = appliedRule;
        this.scoreChange = scoreChange;
        this.reason = reason;
        this.loggedAt = loggedAt;
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

    public RiskRule getAppliedRule() {
        return appliedRule;
    }

    public void setAppliedRule(RiskRule appliedRule) {
        this.appliedRule = appliedRule;
    }

    public Integer getScoreChange() {
        return scoreChange;
    }

    public void setScoreChange(Integer scoreChange) {
        this.scoreChange = scoreChange;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }

    public void setLoggedAt(LocalDateTime loggedAt) {
        this.loggedAt = loggedAt;
    }

    // ✅ Auto timestamp before insert
    @PrePersist
    public void prePersist() {
        loggedAt = LocalDateTime.now();
    }
}
