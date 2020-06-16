package com.example.ss.ss.repository;

import com.example.ss.ss.model.Info;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InfoRepository extends JpaRepository<Info, Long> {
    List<Info> findByStatus(Boolean status);


}
