package com.project1.demo.controller;

import com.project1.demo.data.entity.User;
import com.project1.demo.data.repository.UserRepository;
import com.project1.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dev")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Iterable<User> getUsers(){
        Iterable<User> UserList = this.userService.getUsers();
        return UserList;
    }

    @Autowired
    private UserRepository userRepository;

//    @RequestMapping(value = "/usersS3", method = RequestMethod.GET)
    @GetMapping("/usersS3")
    Page<User> PlayerPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
//        return user2Repository.findAll(new PageRequest(1, 20));

    }
}