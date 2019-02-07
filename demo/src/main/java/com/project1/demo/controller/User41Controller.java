package com.project1.demo.controller;

import com.project1.demo.data.entity.User;
import com.project1.demo.data.repository.User2Repository;
import com.project1.demo.payload.S42Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

//@RestController
@Controller
@RequestMapping(value = "/users41")
public class Player41Controller {

    @Autowired
    private User2Repository user2Repository;

    @RequestMapping(value = "/users4X", method = RequestMethod.GET)
    Page<User> PlayerPageable(Pageable pageable) {
        return user2Repository.findAll(pageable);
//        return user2Repository.findAll(new PageRequest(1, 20));
    }

    @GetMapping("/test/S42/{caca}")
    @ResponseBody
    public S42Response urlSelectS42(ModelMap model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "15") int size) {
        Page<User> data = user2Repository.findAll(PageRequest.of(page, size));
        model.addAttribute("currentPage", page);
        model.addAttribute("currentSize", size);
        return new S42Response(data, page, size, model);
    }

//    @GetMapping("/test/S42/{caca}")
//    @ResponseBody
//    public Page<User> urlSelectS42(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "15") int size) {
////        public Page<User> urlSelectS42(ModelMap model, @PathVariable("urlSelect") String urlSelect, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
////        model.addAttribute("data", user2Repository.findAll(PageRequest.of(page, size)));
////        model.addAttribute("currentPage", page);
////        model.addAttribute("currentSize", size);
////        return "index";
//        return user2Repository.findAll(PageRequest.of(page, size));
//    }

    @GetMapping("/test/{urlSelect}/{caca}")
    public String urlSelect(ModelMap model, @PathVariable("urlSelect") String urlSelect, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        model.addAttribute("data", user2Repository.findAll(PageRequest.of(page, size)));
        model.addAttribute("currentPage", page);
        model.addAttribute("currentSize", size);
        return "test :: resultsList";
    }

    @GetMapping("/test")
    public String showCrudtest(ModelMap model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        model.addAttribute("data", user2Repository.findAll(PageRequest.of(page, size)));
        model.addAttribute("currentPage", page);
        model.addAttribute("currentSize", size);
        return "test :: resultsList";
    }
}
