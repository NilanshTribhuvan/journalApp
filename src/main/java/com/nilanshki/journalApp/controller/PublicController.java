package com.nilanshki.journalApp.controller;

import com.nilanshki.journalApp.entity.User;
import com.nilanshki.journalApp.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserServices userServices;


    @GetMapping("/health-check")
    public String healthCheck(){
        return "ok";
    }

    @PostMapping("/create-user")
    public void createUser(@RequestBody User user){
        userServices. saveNewUser(user);
    }
}
