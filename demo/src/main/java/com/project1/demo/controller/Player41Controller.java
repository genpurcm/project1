package com.project1.demo.controller;

import com.project1.demo.data.entity.Player;
import com.project1.demo.data.repository.Player2Repository;
import com.project1.demo.payload.S42Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

//@RestController
@Controller
@RequestMapping(value = "/players41")
public class Player41Controller {

    @Autowired
    private Player2Repository player2Repository;

    @RequestMapping(value = "/players4X", method = RequestMethod.GET)
    Page<Player> PlayerPageable(Pageable pageable) {
        return player2Repository.findAll(pageable);
//        return player2Repository.findAll(new PageRequest(1, 20));
    }

    @GetMapping("/test/S42/{caca}")
    @ResponseBody
    public S42Response urlSelectS42(ModelMap model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "15") int size) {
        Page<Player> data = player2Repository.findAll(PageRequest.of(page, size));
        model.addAttribute("currentPage", page);
        model.addAttribute("currentSize", size);
        return new S42Response(data, page, size, model);
    }

//    @GetMapping("/test/S42/{caca}")
//    @ResponseBody
//    public Page<Player> urlSelectS42(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "15") int size) {
////        public Page<Player> urlSelectS42(ModelMap model, @PathVariable("urlSelect") String urlSelect, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
////        model.addAttribute("data", player2Repository.findAll(PageRequest.of(page, size)));
////        model.addAttribute("currentPage", page);
////        model.addAttribute("currentSize", size);
////        return "index";
//        return player2Repository.findAll(PageRequest.of(page, size));
//    }

    @GetMapping("/test/{urlSelect}/{caca}")
    public String urlSelect(ModelMap model, @PathVariable("urlSelect") String urlSelect, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        model.addAttribute("data", player2Repository.findAll(PageRequest.of(page, size)));
        model.addAttribute("currentPage", page);
        model.addAttribute("currentSize", size);
        return "test :: resultsList";
    }

    @GetMapping("/test")
    public String showCrudtest(ModelMap model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        model.addAttribute("data", player2Repository.findAll(PageRequest.of(page, size)));
        model.addAttribute("currentPage", page);
        model.addAttribute("currentSize", size);
        return "test :: resultsList";
    }
}
