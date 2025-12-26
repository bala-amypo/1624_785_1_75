package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public String register(RegisterRequest request) {
        // Check if user exists
        if (repository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already taken");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        // 🔥 CRITICAL: Encode password here
        user.setPassword(passwordEncoder.encode(request.getPassword())); 
        
        repository.save(user);
        return "User registered successfully";
    }

    public AuthResponse login(AuthRequest request) {
        // This will throw "Bad credentials" automatically if login fails
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
            )
        );

        // If successful, generate your token (JWT)
        var user = repository.findByEmail(request.getEmail()).orElseThrow();
        return new AuthResponse("dummy-jwt-token-for-" + user.getEmail());
    }
}