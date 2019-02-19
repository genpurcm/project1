package com.project1.demo.service;

import com.project1.demo.data.entity.Role;
import com.project1.demo.data.entity.User;
import com.project1.demo.data.repository.RoleRepository;
import com.project1.demo.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    public void addRole (Role role, String emailAddress) {
        User user = userRepository.findById(emailAddress).orElse(null);
        List<Role> roles = new ArrayList<>(user.getRoles());
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
    }

    public void deleteRole(User user, Role role) {
        List<Role> roles = new ArrayList<>(user.getRoles());
        System.out.println("THE ROLES ARE: " + roles);
        System.out.println("THE ROLES TO BE DELETED IS: " + role);
//        int index = roles.indexOf(role);
        System.out.println("THE INDEX IS: " + roles.indexOf(role));
        System.out.println("THE INDEX 0 IS: " + roles.get(0));
//        roles.remove(roles.indexOf(role));
//        System.out.println("THE NEW ROLE LIST IS: " + roles);
//        user.setRoles(roles);
//        userRepository.save(user);
    }
}
