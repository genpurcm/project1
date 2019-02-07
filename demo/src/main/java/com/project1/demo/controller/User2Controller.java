package com.project1.demo.controller;

import com.project1.demo.data.entity.User;
import com.project1.demo.data.repository.User2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class Player2Controller {

    @Autowired
    private User2Repository user2Repository;

    @RequestMapping(value = "/users2", method = RequestMethod.GET)
    Page<User> PlayerPageable(Pageable pageable) {
        return user2Repository.findAll(pageable);
//        return user2Repository.findAll(new PageRequest(1, 20));

    }


}
