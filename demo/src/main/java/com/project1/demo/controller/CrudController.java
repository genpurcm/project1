package com.project1.demo.controller;

import com.project1.demo.data.entity.Player;
import com.project1.demo.data.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class CrudController {

    @Autowired
    private CrudRepository crudRepository;

    @GetMapping("/crud")
    public String showCrud(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size){
        model.addAttribute("data", crudRepository.findAll(PageRequest.of(page, size)));
        model.addAttribute("currentPage", page);
        model.addAttribute("currentSize", size);
        return "/crud";
    }

    @PostMapping("/save")
    public String save(Player player){
        crudRepository.save(player);
        return "redirect:/crud";
    }

    @GetMapping("/delete")
    public String delete(Long Id){
        crudRepository.deleteById(Id);
        return "redirect:/crud";
    }

    @GetMapping("/findById")
    @ResponseBody
    public Optional<Player> findById(Long Id){
        return crudRepository.findById(Id);
    }
}
