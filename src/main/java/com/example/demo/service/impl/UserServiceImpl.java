package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }
    
    @Override
    public User register(RegisterRequest request) {
        // Check if user already exists
        Optional<User> existing = userRepository.findByEmail(request.getEmail());
        if (existing.isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        
        User user = User.builder()
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .roles(request.getRoles())
            .build();
        return userRepository.save(user);
    }
    
    @Override
    public AuthResponse login(AuthRequest request) {
        return new AuthResponse("mock-token");
    }
}

// package com.example.demo.service.impl;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.User;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.UserService;
// import org.springframework.stereotype.Service;
// @Service
// public class UserServiceImpl implements UserService {

//     private final UserRepository userRepository;

//     public UserServiceImpl(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }
//     @Override
//     public User register(User user) {

//         User existingUser = userRepository.findByEmail(user.getEmail());
//         if (existingUser != null) {
//             throw new BadRequestException("Email already exists");
//         }

//         return userRepository.save(user);
//     }
//     @Override
//     public User login(User user) {

//         User existingUser = userRepository.findByEmail(user.getEmail());
//         if (existingUser == null) {
//             throw new ResourceNotFoundException("User not found");
//         }

//         return existingUser;
//     }
//     @Override
//     public User getByEmail(String email) {

//         User user = userRepository.findByEmail(email);
//         if (user == null) {
//             throw new ResourceNotFoundException("User not found");
//         }

//         return user;
//     }
// }
