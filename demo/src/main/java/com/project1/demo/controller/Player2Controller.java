package com.project1.demo.controller;

import com.project1.demo.data.entity.Player;
import com.project1.demo.data.repository.Player2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class Player2Controller {

    @Autowired
    private Player2Repository player2Repository;

    @RequestMapping(value = "/players2", method = RequestMethod.GET)
    Page<Player> PlayerPageable(Pageable pageable) {
        return player2Repository.findAll(pageable);
//        return player2Repository.findAll(new PageRequest(1, 20));

    }


}
