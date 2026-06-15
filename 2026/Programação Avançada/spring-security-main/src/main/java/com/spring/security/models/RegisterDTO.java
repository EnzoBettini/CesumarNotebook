package com.spring.security.models;

import com.spring.security.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
