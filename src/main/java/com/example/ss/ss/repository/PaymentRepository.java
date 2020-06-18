package com.example.ss.ss.repository;

import com.example.ss.ss.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByEmail(String email);
}
