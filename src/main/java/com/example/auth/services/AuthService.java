package com.example.auth.services;

import com.example.auth.exceptions.InvalidCredentialsException;
import com.example.auth.models.Session;
import com.example.auth.models.User;
import com.example.auth.repositories.SessionRepo;
import com.example.auth.repositories.UserRepo;
import com.example.auth.utils.GenerateToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepo userRepo;
    private final SessionRepo sessionRepo;

    public void signUp(User user) throws InvalidCredentialsException {
        if(userRepo.existsByEmail(user.getEmail())) {
            throw new InvalidCredentialsException("User with same email already exists, please login");
        }
        userRepo.save(user);
    }

    public String login(String email, String password) throws InvalidCredentialsException {
        User user = userRepo.findByEmailAndPassword(email, password);
        if (user == null) {
            throw new InvalidCredentialsException("Invalid email or password provided");
        }
        String token = GenerateToken.generate();
        sessionRepo.save(Session.builder()
                .token(token)
                .user(user)
                .build());
        return token;
    }

    public boolean validate(String token) {
        return sessionRepo.existsByToken(token);
    }

}
