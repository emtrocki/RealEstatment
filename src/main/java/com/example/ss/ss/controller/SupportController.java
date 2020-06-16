package com.example.ss.ss.controller;

import com.example.ss.ss.model.Notification;
import com.example.ss.ss.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class SupportController {
    @Autowired
    private NotificationRepository notificationRepository;

    public SupportController(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @GetMapping("/support")
    public String support(Model model) {
        model.addAttribute("notification", new Notification());
        return "addnotification";
    }

    @PostMapping("/savenotification")
    public String addNotification(Notification notification, Authentication authentication) {
        if (notification.getContent().isEmpty()) {
            return "addnotification";
        } else
            notification.setEmail(authentication.getName());
        notificationRepository.save(notification);
        return "notificationsuccess";
    }

    @GetMapping("/usernotifications")
    public String showUserNotifications(Model model, Authentication authentication) {
        List<Notification> allByEmail = notificationRepository.findAllByEmail(authentication.getName());
        model.addAttribute("notifications", allByEmail);
        return "usernotifications";
    }

    @GetMapping("/shownotifications")
    public String showNotifications(Model model) {
        model.addAttribute("notifications", notificationRepository);
        return "notificationstoserve";
    }
}




