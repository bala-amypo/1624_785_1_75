package com.example.demo.controller;

import com.example.demo.model.RiskScore;
import com.example.demo.service.RiskScoreService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/risk-scores")
@RequiredArgsConstructor
@Tag(name = "RiskScoreController")
public class RiskScoreController {

    private final RiskScoreService riskScoreService;

    @PostMapping("/evaluate/{visitorId}")
    public ResponseEntity<RiskScore> evaluate(@PathVariable Long visitorId) {
        return ResponseEntity.ok(riskScoreService.evaluateVisitor(visitorId));
    }

    @GetMapping("/{visitorId}")
    public ResponseEntity<RiskScore> get(@PathVariable Long visitorId) {
        return ResponseEntity.ok(riskScoreService.getScoreForVisitor(visitorId));
    }

    @GetMapping
    public ResponseEntity<List<RiskScore>> all() {
        return ResponseEntity.ok(riskScoreService.getAllScores());
    }
}




// package com.example.demo.controller;
// import com.example.demo.model.RiskScore;
// import com.example.demo.service.RiskScoreService;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import java.util.List;
// @RestController
// @RequestMapping("/api/risk-scores")
// public class RiskScoreController {
//     private final RiskScoreService service;
//     public RiskScoreController(RiskScoreService service) {
//         this.service = service;
//     }
//     @PostMapping("/evaluate/{visitorId}")
//     public RiskScore evaluateRisk(@PathVariable Long visitorId) {
//         return service.evaluateRisk(visitorId);
//     }
//    @GetMapping("/visitor/{visitorId}")
//     public RiskScore getScoreByVisitor(@PathVariable Long visitorId) {
//         return service.getRiskScoreByVisitor(visitorId);
//     }
//     @GetMapping
//     public List<RiskScore> getAllScores() {
//         return service.getAllRiskScores();
//     }
// }
