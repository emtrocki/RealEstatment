package com.example.ss.ss.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ss.ss.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    UserRole findByRole(String role);
}