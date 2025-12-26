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
public class RiskRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String ruleName;

    private String ruleType;
    private int scoreImpact;
    private int threshold;
}


// package com.example.demo.model;
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.Id;
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
// public class RiskRule {
//     @Id
//     @GeneratedValue
//     private Long id;
//     @Column(unique = true)
//     private String ruleName;
//     private String ruleType;
//     private Integer threshold;
//     private Integer scoreImpact;
//     private LocalDateTime createdAt;
//     @PrePersist
//     void onCreate() {
//         createdAt = LocalDateTime.now();
//     }
// }
