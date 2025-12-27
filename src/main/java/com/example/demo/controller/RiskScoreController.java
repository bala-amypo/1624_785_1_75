package com.example.demo.controller;

import com.example.demo.model.RiskScore;
import com.example.demo.service.RiskScoreService;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-scores")
@Tag(name = "RiskScore")
public class RiskScoreController {

    private final RiskScoreService service;

    public RiskScoreController(RiskScoreService service) {
        this.service = service;
    }

    @PostMapping("/evaluate/{visitorId}")
    public ResponseEntity<RiskScore> evaluate(@PathVariable long visitorId) {
        return ResponseEntity.ok(service.evaluateVisitor(visitorId));
    }

    @GetMapping("/{visitorId}")
    public ResponseEntity<RiskScore> get(@PathVariable long visitorId) {
        return ResponseEntity.ok(service.getScoreForVisitor(visitorId));
    }

    @GetMapping
    public ResponseEntity<List<RiskScore>> all() {
        return ResponseEntity.ok(service.getAllScores());
    }
}



// package com.example.demo.controller;

// import com.example.demo.model.RiskScore;
// import com.example.demo.service.RiskScoreService;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.http.ResponseEntity;

// import java.util.List;

// @Tag(name = "RiskScore")
// public class RiskScoreController {

//     private final RiskScoreService service;

//     public RiskScoreController(RiskScoreService service) {
//         this.service = service;
//     }

//     public ResponseEntity<RiskScore> evaluate(long id) {
//         return ResponseEntity.ok(service.evaluateVisitor(id));
//     }

//     public ResponseEntity<RiskScore> get(long id) {
//         return ResponseEntity.ok(service.getScoreForVisitor(id));
//     }

//     public ResponseEntity<List<RiskScore>> all() {
//         return ResponseEntity.ok(service.getAllScores());
//     }
// }
