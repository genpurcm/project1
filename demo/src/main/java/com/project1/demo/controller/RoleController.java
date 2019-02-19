package com.project1.demo.controller;

import com.project1.demo.data.entity.Role;
import com.project1.demo.data.entity.User;
import com.project1.demo.data.repository.UserRepository;
import com.project1.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/admin/role/addRole")
    public String roleString(String emailAddress, Model model, HttpSession session) {
        session.setAttribute("emailAddress", emailAddress);
        model.addAttribute("emailAddress", emailAddress);
        model.addAttribute("role", new Role());
        return "views/roleForm";
    }

    @PostMapping("/admin/role/addRole")
    public String addRole(@Valid Role role, BindingResult bindingResult, HttpSession session) {
        if(bindingResult.hasErrors()){
            return "views/roleForm";
        }
        String emailAddress = (String) session.getAttribute("emailAddress");
        roleService.addRole(role, emailAddress);
        return "redirect:/admin/user/getUsers";
    }

    @GetMapping("/admin/role/getRoles")
    public String getRoles(Model model, String emailAddress) {
//        String emailAddress = principal.getName();
        User user = userRepository.findById(emailAddress).orElse(null);
        model.addAttribute("roles", user.getRoles());
        model.addAttribute("emailAddress", emailAddress);
        return "views/listRoles";
    }

    @GetMapping("/admin/role/deleteRole")
    public String deleteRole(String emailAddress, Role role) {
        User user = userRepository.findById(emailAddress).orElse(null);
        List<Role> roles = new ArrayList<>(user.getRoles());
        roles.remove(role);
//        roles.remove(roles.indexOf(role));
        user.setRoles(roles);
        userRepository.save(user);
//        roleService.deleteRole(user, role);
        return "views/listRoles";
//        return "redirect:/getRoles";
    }
}
