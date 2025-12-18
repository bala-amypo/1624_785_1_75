package com.example.demo.model;

public class Riskrules{
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long id;
   @Column(unique=true)
   private String ruleName;
   private String ruleType;
   private Integer threshold;
   private Integr scoreImpact;
   private LocalDateTime createdAt;
   @PrePersist
   void validate(){
    if(threshold <0 || scoreImpact <0 ){
        throw new RuntimeException("Invalid rule values");
    }
    createdAt = LocalDateTime.now();
   }
}