package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/visitors")
public class VisitorController {

    @PostMapping
    public ResponseEntity<String> createVisitor(@RequestBody Object visitor) {
        return ResponseEntity.ok("Visitor created successfully");
    }

    @GetMapping
    public ResponseEntity<String> listVisitors() {
        return ResponseEntity.ok("List of visitors");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getVisitor(@PathVariable Long id) {
        return ResponseEntity.ok("Visitor with id: " + id);
    }
}