package com.example.ss.ss.controller;


import com.example.ss.ss.model.Notification;
import com.example.ss.ss.model.User;
import com.example.ss.ss.repository.NotificationRepository;
import com.example.ss.ss.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;


@Controller
public class HomeController {

    private NotificationRepository notificationRepository;


    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/mainpage")
    public String mainpage() {
        return "mainpage";

    }

    @GetMapping("/info")
    public String info() {
        return "info";
    }


}