package com.example.demo.model;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RiskRule {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String ruleName;

    private String ruleType;
    private Integer threshold;
    private Integer scoreImpact;
    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {
        if (threshold < 0 || scoreImpact < 0)
            throw new RuntimeException("Invalid score");
        createdAt = LocalDateTime.now();
    }
}
