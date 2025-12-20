package com.example.demo.model;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "visitor_id", nullable = false, unique = true)
    private Visitor visitor;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private String purpose;
    private String location;
    @PrePersist
    public void validate() {
        if (purpose == null || location == null) {
            throw new RuntimeException("Missing purpose or location");
        }
        this.entryTime = LocalDateTime.now();
    }
    @PreUpdate
    public void validateExit() {
        if (exitTime != null && entryTime != null && exitTime.isBefore(entryTime)) {
            throw new RuntimeException("exitTime must be after entryTime");
        }
    }
}
