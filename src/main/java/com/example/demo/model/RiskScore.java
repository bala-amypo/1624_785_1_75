package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RiskScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    private Visitor visitor;
    
    private Integer totalScore;
    private String riskLevel;
}


// package com.example.demo.model;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.OneToOne;
// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;
// import java.time.LocalDateTime;
// @Entity
// @Getter @Setter
// @Builder
// @NoArgsConstructor
// @AllArgsConstructor
// public class RiskScore {
//     @Id 
//     @GeneratedValue
//     private Long id;
//     @OneToOne
//     private Visitor visitor;
//     private Integer totalScore;
//     private String riskLevel;
//     private LocalDateTime evaluatedAt;
// }
