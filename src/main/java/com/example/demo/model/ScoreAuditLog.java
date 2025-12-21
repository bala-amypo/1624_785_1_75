package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScoreAuditLog {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Visitor visitor;

    @ManyToOne
    private RiskRule appliedRule;

    private Integer scoreChange;
    private String reason;
    private LocalDateTime loggedAt;

    @PrePersist
    void onCreate() {
        if (reason == null) throw new RuntimeException("reason required");
        loggedAt = LocalDateTime.now();
    }
}
