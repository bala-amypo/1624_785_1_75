package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Visitor {
    @Id
    @GeneratedValue
    private Long id;
    private String fullName;
    private String phone;
    private LocalDateTime createdAt;
    @PrePersist
    void onCreate() {
        createdAt = LocalDateTime.now();
    }
    public Long getId() {
     return id; 
     }
    public String getFullName() { 
    return fullName;
     }
    public String getPhone() { 
    return phone; 
    }
    public LocalDateTime getCreatedAt() {
     return createdAt; 
     }
     public void setFullName(String fullName) {
     this.fullName = fullName; 
     }
    public void setPhone(String phone) { 
    this.phone = phone; 
    }
}
