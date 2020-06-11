package com.example.ss.ss.repository;

import com.example.ss.ss.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    Notification findByEmail(String email);
    List<Notification> findAllByEmail(String email);
}
