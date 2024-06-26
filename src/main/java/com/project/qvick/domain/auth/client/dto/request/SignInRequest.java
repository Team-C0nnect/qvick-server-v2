package com.project.qvick.domain.auth.client.dto.request;

public record SignInRequest(
        String email,
        String password
){}
