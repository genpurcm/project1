package com.project1.demo.controller;

import com.project1.demo.data.entity.User;
import com.project1.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Iterable<User> getUsers(){
        Iterable<User> UserList = this.userService.getUsers();
        return UserList;
    }
}