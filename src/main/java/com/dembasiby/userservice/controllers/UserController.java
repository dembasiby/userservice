package com.dembasiby.userservice.controllers;

import com.dembasiby.userservice.dtos.UserDTO;
import com.dembasiby.userservice.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public UserDTO signup(@RequestBody UserDTO userDTO) {
        return userService.signup(userDTO);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDTO userDTO) {
        return userService.login(userDTO);
    }

    @PostMapping("/logout")
    public void logout(@RequestBody UserDTO userDTO) {
        userService.logout(userDTO);
    }
}
