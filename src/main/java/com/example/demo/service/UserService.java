package com.example.demo.service;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    private UserRepository repo;
    public UserService(UserRepository repo) {
        this.repo = repo;
    }
    public User register(User user) {
        return repo.save(user);
    }
    public User getUser(Long id) {
        return repo.findById(id).orElse(null);
    }
}