package com.example.ss.ss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ss.ss.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}