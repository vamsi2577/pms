package com.pm.authservice.dto;

import lombok.Getter;

public class LoginResponseDTO {
    @Getter
    private final String token;

    public LoginResponseDTO(String token) {
        this.token = token;
    }
}
