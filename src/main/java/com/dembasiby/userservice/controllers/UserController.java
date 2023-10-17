package com.dembasiby.userservice.controllers;

import com.dembasiby.userservice.dtos.SetUserRolesRequestDTO;
import com.dembasiby.userservice.dtos.UserDTO;
import com.dembasiby.userservice.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUserDetails(@PathVariable("id") Long userid) {
        UserDTO userDTO = userService.getUserDetails(userid);

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PostMapping("{id}/roles")
    public ResponseEntity<UserDTO> setUserRoles(@PathVariable("id") Long userId, @RequestBody SetUserRolesRequestDTO request) {
        UserDTO userDTO = userService.setUserRoles(userId, request.getRoleIds());

        return new ResponseEntity<>(userDTO, HttpStatus.OK);

    }


}
