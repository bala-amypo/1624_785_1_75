package com.example.demo.model;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;
@Entity
public class VisitLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Visitor visitor;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private String purpose;
    private String location;
    public VisitLog() {
    }
    public VisitLog(String purpose, String location) {
        this.purpose = purpose;
        this.location = location;
    }
    @PrePersist
    void validate() {
        if (purpose == null || location == null) {
            throw new RuntimeException("Missing purpose or location");
        }
        entryTime = LocalDateTime.now();
    }
    @PreUpdate
    void validateExit() {
        if (exitTime != null && exitTime.isBefore(entryTime)) {
            throw new RuntimeException("exitTime must be after entryTime");
        }
    }
    public Long getId() {
        return id;
    }
    public Visitor getVisitor() {
        return visitor;
    }
    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }
    public LocalDateTime getEntryTime() {
        return entryTime;
    }
    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getLocation() {
        return location;
    }
}