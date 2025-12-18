package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.LocalDateTime;
import jakarta.persistence .PrePersist;
@Entity
public class RiskScore{
  @Id
  @GeneratedValue(strategy=GenerationType.INDENTITY)
  private Long id;
  private Integer 
}