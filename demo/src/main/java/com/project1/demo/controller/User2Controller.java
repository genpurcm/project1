package com.project1.demo.controller;

import com.project1.demo.data.entity.User;
import com.project1.demo.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class User2Controller {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/usersS3", method = RequestMethod.GET)
    Page<User> PlayerPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
//        return user2Repository.findAll(new PageRequest(1, 20));

    }
}
