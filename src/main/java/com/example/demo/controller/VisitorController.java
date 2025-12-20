package com.example.demo.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
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