package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.AuthService;
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public Object register(@RequestBody Object user) {
        return authService.register(user);
    }

    @PostMapping("/login")
    public Object login(@RequestBody Object loginRequest) {
        return authService.login(loginRequest);
    }
}