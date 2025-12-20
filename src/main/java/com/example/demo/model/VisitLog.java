package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "visit_logs")
public class VisitLog {

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long id;

    // @ManyToOne(optional = false, fetch = FetchType.LAZY)
    // @JoinColumn(name = "visitor_id", nullable = false)
    // private Visitor visitor;

    // @Column(nullable = false)
    // private LocalDateTime entryTime;

    // private LocalDateTime exitTime;

    // @Column(nullable = false)
    // private String purpose;

    // private String location;

    // // Constructors
    // public VisitLog() {
    // }

    // public VisitLog(Visitor visitor, LocalDateTime entryTime, String purpose, String location) {
    //     this.visitor = visitor;
    //     this.entryTime = entryTime;
    //     this.purpose = purpose;
    //     this.location = location;
    // }

    // // Getters and Setters
    // public Long getId() {
    //     return id;
    // }

    // public Visitor getVisitor() {
    //     return visitor;
    // }

    // public void setVisitor(Visitor visitor) {
    //     this.visitor = visitor;
    // }

    // public LocalDateTime getEntryTime() {
    //     return entryTime;
    // }

    // public void setEntryTime(LocalDateTime entryTime) {
    //     this.entryTime = entryTime;
    // }

    // public LocalDateTime getExitTime() {
    //     return exitTime;
    // }

    // public void setExitTime(LocalDateTime exitTime) {
    //     this.exitTime = exitTime;
    // }

    // public String getPurpose() {
    //     return purpose;
    // }

    // public void setPurpose(String purpose) {
    //     this.purpose = purpose;
    // }

    // public String getLocation() {
    //     return location;
    // }

    // public void setLocation(String location) {
    //     this.location = location;
    // }
}
