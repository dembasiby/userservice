package com.dembasiby.userservice.services;

import com.dembasiby.userservice.dtos.UserDTO;
import com.dembasiby.userservice.models.Role;
import com.dembasiby.userservice.models.User;
import com.dembasiby.userservice.repositories.RoleRepository;
import com.dembasiby.userservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    public UserDTO getUserDetails(Long userid) {
        Optional<User> optionalUser = userRepository.findById(userid);
        return optionalUser.map(UserDTO::from).orElse(null);
    }

    public UserDTO setUserRoles(Long userid, List<Long> roleIds) {
        Optional<User> optionalUser = userRepository.findById(userid);
        List<Role> roles = roleRepository.findAllByIdIn(roleIds);

        if (optionalUser.isEmpty()) {
            return null;
        }

        User user = optionalUser.get();
        user.setRoles(Set.copyOf(roles));
        User savedUser = userRepository.save(user);

        return UserDTO.from(savedUser);
    }
}
