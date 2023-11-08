package com.example.auth.repositories;

import com.example.auth.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepo extends JpaRepository<Session, Integer> {
    boolean existsByToken(String token);
}
