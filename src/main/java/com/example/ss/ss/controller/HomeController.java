package com.example.ss.ss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {



    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/mainpage")
    public String mainpage() {
        return "redirect/";

    }


}