package com.project1.demo.controller;

import com.project1.demo.data.entity.Player;
import com.project1.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.project1.demo.data.entity.Player;
import com.project1.demo.payload.UploadFileResponse;
import com.project1.demo.service.PlayerService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public Iterable<Player> getPlayers(){
        Iterable<Player> PlayerList = this.playerService.getPlayers();
//        model.addAttribute("roomReservations", roomReservationList);
        return PlayerList;

    }


}