package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.LocalDateTime;
import jakarta.persistence .PrePersist;
@Entity
public class Visitor{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String idProof;
    private LocalDateTime createdAt;
    @PrePersist
    void validateAndCreate(){
      if(phone==null || phone.isEmpty()){
        throw new RunTimeException("phone required");
      }
      this.createdAt = LocalDateTime.now();
    }
    public Long getId(){
        return id;
    }
    public String 

}