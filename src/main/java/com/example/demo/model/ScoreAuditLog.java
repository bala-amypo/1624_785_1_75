import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "score_audit_logs")
public class ScoreAuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "visitor_id", nullable = false)
    private Visitor visitor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "risk_rule_id")
    private RiskRule appliedRule;

    @Column(nullable = false)
    private Integer scoreChange;

    @Column(nullable = false)
    private String reason;

    @Column(nullable = false)
    private LocalDateTime loggedAt;

    // Constructors
    public ScoreAuditLog() {
        this.loggedAt = LocalDateTime.now();
    }

    public ScoreAuditLog(Visitor visitor, RiskRule appliedRule,
                         Integer scoreChange, String reason) {
        this.visitor = visitor;
        this.appliedRule = appliedRule;
        this.scoreChange = scoreChange;
        this.reason = reason;
        this.loggedAt = LocalDateTime.now();
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
}
