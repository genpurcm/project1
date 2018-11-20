package com.project1.demo.service;

import com.project1.demo.data.entity.Player;
import com.project1.demo.data.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public void AddPlayer(Player player){
        playerRepository.save(player);

    }

}
