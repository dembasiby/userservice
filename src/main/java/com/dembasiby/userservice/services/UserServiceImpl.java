package com.dembasiby.userservice.services;

import com.dembasiby.userservice.dtos.UserDTO;
import com.dembasiby.userservice.models.User;
import com.dembasiby.userservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO signup(UserDTO userDTO) {
        User user = new User();
        user.setUuid(UUID.randomUUID());
        user.setEmail(userDTO.getEmail());
        user.setEncPassword(userDTO.getEncPassword());
        userRepository.save(user);

        userDTO.setId(user.getUuid().toString());
        userDTO.setEncPassword(user.getEncPassword());
        return userDTO;
    }

    @Override
    public String login(UserDTO userDTO) {
        return null;
    }

    @Override
    public void logout(UserDTO userDTO) {
    }
}
