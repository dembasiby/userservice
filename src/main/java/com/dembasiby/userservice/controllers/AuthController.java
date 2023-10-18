package com.dembasiby.userservice.controllers;

import com.dembasiby.userservice.dtos.LoginRequestDTO;
import com.dembasiby.userservice.dtos.SignUpRequestDTO;
import com.dembasiby.userservice.dtos.UserDTO;
import com.dembasiby.userservice.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {this.authService = authService;}

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody LoginRequestDTO request) {
        return authService.login(request.getEmail(), request.getPassword());
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> login(@RequestBody SignUpRequestDTO request) {
        UserDTO userDTO = authService.signUp(request.getEmail(), request.getPassword());
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
}
