package com.dembasiby.userservice.services;

import com.dembasiby.userservice.models.Role;
import com.dembasiby.userservice.repositories.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role createRole(String name) {
        Role role = new Role();
        role.setRole(name);
        roleRepository.save(role);

        return role;
    }
}
