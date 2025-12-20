package com.example.demo.service.impl;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.exception.ResourceNotFoundException;
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
    public User login(User request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        if (!request.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return user;
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
