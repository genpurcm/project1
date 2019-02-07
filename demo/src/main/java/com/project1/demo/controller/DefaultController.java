package com.project1.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class DefaultController {

    // inject via application.properties
    @Value("${index.message:test}")
    private String message = "Hello World!!!";

    @GetMapping("/")
//    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndexPage(ModelMap model) {
        SecurityContext context = SecurityContextHolder.getContext();
        model.addAttribute("message", "You are logged in as "
                + context.getAuthentication().getName());
        model.put("indexcontroller", this.message);
        return "/index";
    }

    @GetMapping("/index")
    public String index(){
        return "/index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

    @GetMapping("/indexori")
    public String indexori(ModelMap model) {
        // Get authenticated user name from SecurityContext
        SecurityContext context = SecurityContextHolder.getContext();
        model.addAttribute("message", "You are logged in as "
                + context.getAuthentication().getName());
        model.put("indexcontroller", this.message);
        return "/indexori";
    }



}
