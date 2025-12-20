package com.example.service.impl;
import com.example.demo.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User register(User user) {
        return userRepository.save(user);
    }
    @Override
    public AuthResponse login(AuthRequest request) {
      User user = userRepository.findByEmail(request.getEmail());
      AuthResponse response = new AuthResponse();
        response.setMessage("Login successful");
        response.setUser(user);
        return response;
    }
    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}