package com.project1.demo.controller;

import com.project1.demo.data.entity.User;
import com.project1.demo.data.repository.UserRepository;
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
public class User41Controller {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/users4X", method = RequestMethod.GET)
    Page<User> UserPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
//        return userRepository.findAll(new PageRequest(1, 20));
    }

    @GetMapping("/test/S42/{caca}")
    @ResponseBody
    public S42Response urlSelectS42(ModelMap model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "15") int size) {
        Page<User> data = userRepository.findAll(PageRequest.of(page, size));
        model.addAttribute("currentPage", page);
        model.addAttribute("currentSize", size);
        return new S42Response(data, page, size, model);
    }

//    @GetMapping("/test/S42/{caca}")
//    @ResponseBody
//    public Page<User> urlSelectS42(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "15") int size) {
////        public Page<User> urlSelectS42(ModelMap model, @PathVariable("urlSelect") String urlSelect, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
////        model.addAttribute("data", userRepository.findAll(PageRequest.of(page, size)));
////        model.addAttribute("currentPage", page);
////        model.addAttribute("currentSize", size);
////        return "index";
//        return userRepository.findAll(PageRequest.of(page, size));
//    }

    @GetMapping("/test/{urlSelect}/{caca}")
    public String urlSelect(ModelMap model, @PathVariable("urlSelect") String urlSelect, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        model.addAttribute("data", userRepository.findAll(PageRequest.of(page, size)));
        model.addAttribute("currentPage", page);
        model.addAttribute("currentSize", size);
        return "test :: resultsList";
    }

    @GetMapping("/test")
    public String showCrudtest(ModelMap model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        model.addAttribute("data", userRepository.findAll(PageRequest.of(page, size)));
        model.addAttribute("currentPage", page);
        model.addAttribute("currentSize", size);
        return "test :: resultsList";
    }
}
