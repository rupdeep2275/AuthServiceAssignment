package com.example.auth.DTOs;

import com.example.auth.models.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private String email;
    private String password;
    private String fullName;

    public User toUser() {
        return User.builder()
                .email(email)
                .password(password)
                .fullName(fullName)
                .build();
    }
}
