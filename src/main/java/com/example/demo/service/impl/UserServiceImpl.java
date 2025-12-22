// package com.example.demo.service.impl;
// import com.example.demo.model.User;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.UserService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.stereotype.Service;
// @Service
// public class UserServiceImpl implements UserService {
//     private final UserRepository repository;
//     private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//     public UserServiceImpl(UserRepository repository) {
//         this.repository = repository;
//     }
//    @Override
//     public User register(User user) {
//         user.setPassword(encoder.encode(user.getPassword()));
//         return repository.save(user);
//     }
//     @Override
//     public User login(User user) {
//         User dbUser = repository.findByEmail(user.getEmail());
//         if (dbUser == null ||
//             !encoder.matches(user.getPassword(), dbUser.getPassword())) {
//             throw new RuntimeException("Invalid credentials");
//         }
//         return dbUser;
//     }
//     @Override
//     public User getByEmail(String email) {
//         return repository.findByEmail(email);
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
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

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new BadRequestException("Email already exists");
        }

        return userRepository.save(user);
    }

    @Override
    public User login(User user) {
        return userRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
    @Override
public User getByEmail(String email) {
    return userRepository.findByEmail(email)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
}

}
