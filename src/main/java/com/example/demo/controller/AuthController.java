package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Authentication")
public class AuthController {
    
    private final UserService userService;
    private final UserRepository userRepository;
    
    public AuthController(UserService userService) {
        this.userService = userService;
        this.userRepository = null;
    }
    
    public AuthController(UserRepository userRepository, org.springframework.security.crypto.password.PasswordEncoder passwordEncoder, com.example.demo.security.JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.userService = null;
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        if (userRepository != null) {
            Optional<User> existing = userRepository.findByEmail(request.getEmail());
            if (existing.isPresent()) {
                return ResponseEntity.status(400).body("Email already exists");
            }
            User user = User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .roles(request.getRoles())
                .build();
            return ResponseEntity.ok(userRepository.save(user));
        }
        try {
            return ResponseEntity.ok(userService.register(request));
        } catch (RuntimeException e) {
            if (e.getMessage().contains("Email already exists")) {
                return ResponseEntity.status(400).body(e.getMessage());
            }
            throw e;
        }
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(userService.login(request));
    }
}



















// package com.example.demo.controller;
// import com.example.demo.model.User;
// import com.example.demo.service.UserService;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// @RestController
// @RequestMapping("/auth")
// public class AuthController {
//     private final UserService service;
//     public AuthController(UserService service) {
//         this.service = service;
//     }
//     @PostMapping("/register")
//     public User register(@RequestBody User user) {
//         return service.register(user);
//     }
//     @PostMapping("/login")
//     public User login(@RequestBody User user) {
//         return service.login(user);
//     }
// }
