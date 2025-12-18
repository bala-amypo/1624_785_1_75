package com.example.demo.model;
@Entity
public class VisitLog{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
      private Long id;
      private LocalDateTime entryTime;
       private LocalDateTime exitTime;
      private String purpose;
      private String location;
      @PrePersist
      void validate(){
        if(purpose)
      }
}