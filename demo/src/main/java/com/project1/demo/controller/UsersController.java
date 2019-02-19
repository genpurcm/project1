package com.project1.demo.controller;

import com.project1.demo.data.repository.UserRepository;
import com.project1.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin/user/getUsers")
    public String listUsers(Model model){
        model.addAttribute("users", userService.getUsers());
        return "views/listUsers";
    }
}
