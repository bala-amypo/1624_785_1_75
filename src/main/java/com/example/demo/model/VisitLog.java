package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.LocalDateTime;
import jakarta.persistence .PrePersist;
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
        if(purpose==null || location==null){
            throw new RunTimeException("purpose and location required");
        }
        entryTime = LocalDateTime.now();
      }
      public Long getId(){
        return id;
      }
      public Visitor getVisitor(){
        return Visitor;
      }
      public void setVisitor(Visitor visitor){
        this.visitor=visitor;
      }
      public String getPurpose(){
        return purpose;
      }
      public void setPurpose(String purpose){
        this.purpose=purpose;
      }
      public String getLocation(){
         return location;
      }
      public void setLocation(String location){
        this.location=location;
      }
      public LocalDateTime
}