package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;

public interface UserService {
    AuthResponse login(AuthRequest request);

    User register(RegisterRequest request);
}

// package com.example.demo.service;
// import com.example.demo.model.User;
// public interface UserService {
//     User register(User user);
//     User login(User user);
//     User getByEmail(String email);
// }
