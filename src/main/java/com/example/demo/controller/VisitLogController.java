package com.example.demo.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/visit-logs")
public class VisitLogController {
    @PostMapping("/{visitorId}")
    public ResponseEntity<String> createVisitLog(@PathVariable Long visitorId) {
        return ResponseEntity.ok("Visit log created for visitor " + visitorId);
    }
    @GetMapping("/visitor/{visitorId}")
    public ResponseEntity<String> listLogsForVisitor(@PathVariable Long visitorId) {
        return ResponseEntity.ok("Visit logs for visitor " + visitorId);
    }
    @GetMapping("/{id}")
    public ResponseEntity<String> getVisitLog(@PathVariable Long id) {
        return ResponseEntity.ok("Visit log with id: " + id);
    }
}