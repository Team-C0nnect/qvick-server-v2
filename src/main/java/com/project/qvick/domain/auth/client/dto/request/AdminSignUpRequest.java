package com.project.qvick.domain.auth.client.dto.request;

public record AdminSignUpRequest(
        String name,
        String email,
        String password
){}
