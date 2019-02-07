package com.project1.demo.service;

import com.project1.demo.data.entity.Player;
import com.project1.demo.data.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

//import com.project1.demo.data.entity.Role;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public void AddPlayer(Player player){
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        player.setPassword(encoder.encode(player.getPassword()));
        player.setPassword(new BCryptPasswordEncoder().encode(player.getPassword()));
        System.out.println(player.getPassword());
        playerRepository.save(player);
    }
//    public void AddUser(Player player){
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        player.setPassword(encoder.encode(player.getPassword()));
//        Role userRole = new Role("USER");
//        List<Role> roles = new ArrayList<>();
//        roles.add(userRole);
//        player.setRoles(roles);
//        playerRepository.save(player);
//    }
//    public void AddAdmin(Player player){
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        player.setPassword(encoder.encode(player.getPassword()));
//        Role userRole = new Role("ADMIN");
//        List<Role> roles = new ArrayList<>();
//        roles.add(userRole);
//        player.setRoles(roles);
//        playerRepository.save(player);
//    }
    public Iterable<Player> getPlayers(){
//        Iterable<Player> foundPlayers = playerRepository.findAll();
        return playerRepository.findAll();
    }


//    public Player GetPlayerByName(String name){
//        playerRepository.findByName(String name);
//    }


}
