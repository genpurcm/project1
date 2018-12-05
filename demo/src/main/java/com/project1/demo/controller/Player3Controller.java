package com.project1.demo.controller;

import com.project1.demo.data.entity.Player;
import com.project1.demo.data.repository.Player3Repository;
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
public class Player3Controller {


    @Autowired
    private Player3Repository player3Repository;

    @GetMapping("/players3")
    public String showPlayer3(Model model, @RequestParam(defaultValue = "0") int page){
        model.addAttribute("data", player3Repository.findAll(PageRequest.of(page, 5)));
        model.addAttribute("currentPage", page);
        return "player3";
    }

    @PostMapping("/save")
    public String save(Player player){
        player3Repository.save(player);
        return "redirect:players3";
    }

    @GetMapping("/delete")
    public String delete(Long Id){
        player3Repository.deleteById(Id);
        return "redirect:/players3";
    }

    @GetMapping("/findById")
    @ResponseBody
    public Optional<Player> findById(Long Id){
        return player3Repository.findById(Id);
    }


}