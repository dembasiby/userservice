package com.dembasiby.userservice.services;

import com.dembasiby.userservice.dtos.UserDTO;
import com.dembasiby.userservice.models.User;
import com.dembasiby.userservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO signUp(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        User savedUser = userRepository.save(user);

        return UserDTO.from(savedUser);
    }
}
