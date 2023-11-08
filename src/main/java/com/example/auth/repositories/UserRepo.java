package com.example.auth.repositories;

import com.example.auth.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByEmailAndPassword(String email, String password);
    boolean existsByEmail(String email);
}
