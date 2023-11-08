package com.example.auth.utils;

import java.util.UUID;

public class GenerateToken {
    public static String generate(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().substring(0, 20);
    }
}
