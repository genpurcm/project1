package com.project1.demo.service;

import com.project1.demo.data.entity.User;
import com.project1.demo.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

//import com.project1.demo.data.entity.Role;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void AddUser(User user){
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        user.setPassword(encoder.encode(user.getPassword()));
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        System.out.println(user.getPassword());
        userRepository.save(user);
    }
//    public void AddUser(User player){
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        player.setPassword(encoder.encode(player.getPassword()));
//        Role userRole = new Role("USER");
//        List<Role> roles = new ArrayList<>();
//        roles.add(userRole);
//        player.setRoles(roles);
//        userRepository.save(player);
//    }
//    public void AddAdmin(User player){
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        player.setPassword(encoder.encode(player.getPassword()));
//        Role userRole = new Role("ADMIN");
//        List<Role> roles = new ArrayList<>();
//        roles.add(userRole);
//        player.setRoles(roles);
//        userRepository.save(player);
//    }
    public Iterable<User> getUsers(){
//        Iterable<User> foundPlayers = userRepository.findAll();
        return userRepository.findAll();
    }

    public boolean isUserPresent(String emailAddress) {
        User u = userRepository.findById(emailAddress).orElse(null);
        System.out.println(u);
        if (u != null)
            return true;
        return false;
    }

//    public User GetPlayerByName(String name){
//        userRepository.findByName(String name);
//    }


}
