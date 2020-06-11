package com.example.ss.ss.controller;

import com.example.ss.ss.model.Notification;
import com.example.ss.ss.repository.NotificationRepository;
import com.example.ss.ss.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SupportController {

    private NotificationRepository notificationRepository;

    public SupportController(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @GetMapping("/support")
    public String support(Model model) {
        model.addAttribute("notification", new Notification());
        return "addNotification";
    }


    @PostMapping("/saveNotification")
    public String addNotification(Notification notification, Authentication authentication) {
        notification.setEmail(authentication.getName());
        notificationRepository.save(notification);
        return "notificationSuccess";
    }

    @GetMapping("/userNotifications")
    public String showUserNotifications(Model model, Authentication authentication) {
        List<Notification> allByEmail = notificationRepository.findAllByEmail(authentication.getName());
        model.addAttribute("notifications", allByEmail);
        return "userNotifications";
    }
    

}
