package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GeneratedType;
import jakarta.perisitence.Id;

@Entity
public class User{
    @Id
    @GeneratedValue
}