package com.example.demo.controller;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/visit-logs")
public class VisitLogController {

    private final VisitLogService service;

    public VisitLogController(VisitLogService service) {
        this.service = service;
    }

    @PostMapping("/{visitorId}")
    public VisitLog createLog(
            @PathVariable Long visitorId,
            @RequestBody VisitLog visitLog) {
        return service.createVisitLog(visitorId, visitLog);
    }

    @GetMapping("/{id}")
    public VisitLog getLog(@PathVariable Long id) {
        return service.getVisitLogById(id);
    }

    @GetMapping("/visitor/{visitorId}")
    public List<VisitLog> getLogsByVisitor(@PathVariable Long visitorId) {
        return service.getLogsByVisitor(visitorId);
    }
}
