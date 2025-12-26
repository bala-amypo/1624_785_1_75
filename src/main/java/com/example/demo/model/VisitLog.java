package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime entryTime;
    private LocalDateTime exitTime;

    @ManyToOne
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;

    @PrePersist
    public void onCreate() {
        entryTime = LocalDateTime.now();
    }
}



// package com.example.demo.model;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.Id;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.PrePersist;
// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;
// import java.time.LocalDateTime;
// @Entity
// @Getter
// @Setter
// @Builder
// @NoArgsConstructor
// @AllArgsConstructor
// public class VisitLog {
//     @Id
//     @GeneratedValue
//     private Long id;
//     @ManyToOne
//     private Visitor visitor;
//     private LocalDateTime entryTime;
//     private LocalDateTime exitTime;
//     private String purpose;
//     private String location;
//     @PrePersist
//     void onCreate() {
//         entryTime = LocalDateTime.now();
//     }
// }
