package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Visitor {

    @Id @GeneratedValue
    private Long id;

    private String fullName;
    private String email;
    private String phone;
    private String idProof;
    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {
        if (phone == null) throw new RuntimeException("phone required");
        createdAt = LocalDateTime.now();
    }
}
