package qvick.auth.request;

public record AdminSignUpRequest(
        String name,
        String email,
        String password
){}
