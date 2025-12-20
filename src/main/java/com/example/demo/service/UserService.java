package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.payload.AuthRequest;
import com.example.demo.payload.AuthResponse;
import com.example.demo.payload.RegisterRequest;

public interface UserService {

    User register(RegisterRequest request);

    AuthResponse login(AuthRequest request);

    User getByEmail(String email);
}
