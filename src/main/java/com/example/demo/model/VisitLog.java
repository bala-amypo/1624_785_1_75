package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VisitLog {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Visitor visitor;

    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private String purpose;
    private String location;

    @PrePersist
    void onCreate() {
        entryTime = LocalDateTime.now();
        if (exitTime != null && exitTime.isBefore(entryTime))
            throw new RuntimeException("exitTime must be after entryTime");
    }
}
