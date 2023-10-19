package com.dembasiby.userservice.controllers;

import com.dembasiby.userservice.dtos.CreateRoleRequestDTO;
import com.dembasiby.userservice.models.Role;
import com.dembasiby.userservice.services.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {this.roleService = roleService;}

    @PostMapping
    public ResponseEntity<Role> createRole(CreateRoleRequestDTO request) {
        Role role = roleService.createRole(request.getName());
        return new ResponseEntity<>(role, HttpStatus.OK);
    }
}
