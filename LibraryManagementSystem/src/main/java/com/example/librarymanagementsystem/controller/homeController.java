package com.example.librarymanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //api on utilise RestController

public class homeController {


    @GetMapping("/user/home")
    public String Home(){

        return "home";
    }

    @GetMapping("/")
    public String home()
    {
        return "redirect:/user/home";
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
