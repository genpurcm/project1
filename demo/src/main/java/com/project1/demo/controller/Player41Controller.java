package com.project1.demo.controller;

import com.project1.demo.data.entity.Player;
import com.project1.demo.data.repository.Player2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class Player41Controller {

    @Autowired
    private Player2Repository player2Repository;

    @RequestMapping(value = "/players41", method = RequestMethod.GET)
    Page<Player> PlayerPageable(Pageable pageable) {
        return player2Repository.findAll(pageable);
//        return player2Repository.findAll(new PageRequest(1, 20));

    }

//    @GetMapping("/players411")
//    public String showCrud(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
//        model.addAttribute("data", player2Repository.findAll(PageRequest.of(page, size)));
//        model.addAttribute("currentPage", page);
//        model.addAttribute("currentSize", size);
//        return "/index";
//    }


    @GetMapping("/players411")
    public Page<Player> showCrud(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
//        model.addAttribute("data", );
//        model.addAttribute("currentPage", page);
//        model.addAttribute("currentSize", size);
        return player2Repository.findAll(PageRequest.of(page, size));
    }
}
