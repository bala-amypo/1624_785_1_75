package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScoreAuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Visitor visitor;
    
    @ManyToOne
    private RiskScore riskScore;
    
    private String reason;
    private Integer scoreChange;
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
