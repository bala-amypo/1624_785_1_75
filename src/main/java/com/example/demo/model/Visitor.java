package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String idProof;
    private LocalDateTime createdAt;
    @PrePersist
    public void validate() {
        if (fullName == null || phone == null || idProof == null) {
            throw new RuntimeException("fullName, phone and idProof are required");
        }
        this.createdAt = LocalDateTime.now();
    }
}
