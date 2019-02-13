package com.project1.demo.controller;

import com.project1.demo.data.entity.User;
import com.project1.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@Controller
public class SignUPController {

    @Autowired
    private UserService userService;

    @GetMapping("/signUP")
    public String signUpForm(Model model) {
        model.addAttribute("user", new User());
        return "views/signUpForm";
    }

    @PostMapping("/signUP")
    public String signUpUser(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "views/signUpForm";
        }
        if (userService.isUserPresent(user.getEmailAddress())) {
            model.addAttribute("exist", true);
            return "views/signUpForm";
        }
        userService.AddUser(user);
        return "views/success";
    }
}
