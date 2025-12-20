package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Visitor;
import com.example.demo.service.VisitorService;

@RestController
@RequestMapping("/api/visitors")
public class VisitorController {

    private final VisitorService visitorService;

    // ✅ Constructor injection for test compatibility
    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    // POST /api/visitors
    @PostMapping
    public ResponseEntity<?> createVisitor(@RequestBody Visitor visitor) {
        try {
            Visitor created = visitorService.createVisitor(visitor);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (Exception e) {
            // Tests expect "phone required" message for missing phone
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // GET /api/visitors/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> getVisitor(@PathVariable Long id) {
        try {
            Visitor visitor = visitorService.getVisitor(id);
            return ResponseEntity.ok(visitor);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // GET /api/visitors
    @GetMapping
    public ResponseEntity<List<Visitor>> getAllVisitors() {
        List<Visitor> visitors = visitorService.getAllVisitors();
        return ResponseEntity.ok(visitors); // returns empty list if none
    }
}
