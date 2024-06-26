package com.project.qvick.domain.auth.client.dto.request;

public record SignUpRequest(
        String name,
        String email,
        String password,
        String stdId,
        String room
){}
