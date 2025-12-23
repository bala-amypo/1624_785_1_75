package com.example.demo.service.impl;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User register(User user) {

        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            throw new BadRequestException("Email already exists");
        }

        return userRepository.save(user);
    }
    @Override
    public User login(User user) {

        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser == null) {
            throw new ResourceNotFoundException("User not found");
        }

        return existingUser;
    }
    @Override
    public User getByEmail(String email) {

        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        }

        return user;
    }
}
