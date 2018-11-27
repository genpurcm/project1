package com.project1.demo.service;

import com.project1.demo.data.entity.Player;
import com.project1.demo.data.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public void AddPlayer(Player player){
        playerRepository.save(player);

    }

    public Iterable<Player> getPlayers(){
//        Iterable<Player> foundPlayers = playerRepository.findAll();
        return playerRepository.findAll();
    }

//    public Player GetPlayerByName(String name){
//        playerRepository.findByName(String name);
//    }


}
