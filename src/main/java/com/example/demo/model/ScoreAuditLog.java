package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScoreAuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reason;

    @ManyToOne
    private RiskScore riskScore;
}


// package com.example.demo.model;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.Id;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.PrePersist;
// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;
// import java.time.LocalDateTime;
// @Entity
// @Getter
// @Setter
// @Builder
// @NoArgsConstructor
// @AllArgsConstructor
// public class ScoreAuditLog {
//     @Id
//     @GeneratedValue
//     private Long id;
//     @ManyToOne
//     private Visitor visitor;
//     @ManyToOne
//     private RiskRule appliedRule;
//     private Integer scoreChange;
//     private String reason;
//     private LocalDateTime loggedAt;
//     @PrePersist
//     void onCreate() {
//         loggedAt = LocalDateTime.now();
//     }
// }
