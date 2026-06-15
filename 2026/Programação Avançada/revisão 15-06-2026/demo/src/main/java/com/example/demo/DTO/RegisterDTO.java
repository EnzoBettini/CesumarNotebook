package com.example.demo.DTO;

import com.example.demo.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
