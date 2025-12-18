package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.LocalDateTime;
import jakarta.persistence .PrePersist;
import jakarta.persistence.Column;
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
   public Long getId(){
    return id;
   }
   public void setId(Long id){
    this.id=id;
   }
   public String getRuleName(){
    return ruleName;
   }
}