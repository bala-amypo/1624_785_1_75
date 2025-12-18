package com.example.demo.model;
import jakarta.persistence.*;
import java.util.Set;
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    private String password;
    @ElementCollection
    private Set<String> role;
    public User() {
    }
    public User(String email, String password, Set<String> role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public Long getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Set<String> getRole() {
        return role;
    }
    public void setRole(Set<String> role) {
        this.role = role;
    }
}