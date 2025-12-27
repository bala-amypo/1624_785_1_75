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

@Service   
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public User register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User user = User.builder()
                .email(request.getEmail())
                .password(
                        request.getPassword() == null
                                ? null
                                : passwordEncoder.encode(request.getPassword())
                )
                .roles(request.getRoles())
                .build();

        return userRepository.save(user);
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        
        String token = jwtTokenProvider.generateToken(request.getEmail());
        return new AuthResponse(token);
    }
}




// package com.example.demo.service.impl;

// import com.example.demo.dto.AuthRequest;
// import com.example.demo.dto.AuthResponse;
// import com.example.demo.dto.RegisterRequest;
// import com.example.demo.model.User;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.security.JwtTokenProvider;
// import com.example.demo.service.UserService;
// import org.springframework.security.crypto.password.PasswordEncoder;

// public class UserServiceImpl implements UserService {

//     private final UserRepository userRepository;
//     private final PasswordEncoder passwordEncoder;
//     private final JwtTokenProvider jwtTokenProvider;

//     public UserServiceImpl(UserRepository userRepository,
//                            PasswordEncoder passwordEncoder,
//                            JwtTokenProvider jwtTokenProvider) {
//         this.userRepository = userRepository;
//         this.passwordEncoder = passwordEncoder;
//         this.jwtTokenProvider = jwtTokenProvider;
//     }

//     @Override
//     public User register(RegisterRequest request) {
//         if (userRepository.findByEmail(request.getEmail()).isPresent()) {
//             throw new RuntimeException("Email already exists");
//         }

//         User user = User.builder()
//                 .email(request.getEmail())
//                 .password(
//                         request.getPassword() == null
//                                 ? null
//                                 : passwordEncoder.encode(request.getPassword())
//                 )
//                 .roles(request.getRoles())
//                 .build();

//         return userRepository.save(user);
//     }

//     @Override
//     public AuthResponse login(AuthRequest request) {
//         return new AuthResponse("token");
//     }
// }
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

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public User register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        // ✅ NO Lombok builder – manual object creation
        User user = new User();
        user.setEmail(request.getEmail());

        if (request.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        } else {
            user.setPassword(null);
        }

        user.setRoles(request.getRoles());

        return userRepository.save(user);
    }

    @Override
    public AuthResponse login(AuthRequest request) {

        // (Password validation can be added later)
        String token = jwtTokenProvider.generateToken(request.getEmail());
        return new AuthResponse(token);
    }
}
