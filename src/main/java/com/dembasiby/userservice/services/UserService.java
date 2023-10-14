package com.dembasiby.userservice.services;

import com.dembasiby.userservice.dtos.UserDTO;

public interface UserService {
    UserDTO signup(UserDTO userDTO);

    String login(UserDTO userDTO);
    void logout(UserDTO userDTO);
}
