package qvick.auth.request;

public record SignUpRequest(
        String name,
        String email,
        String password,
        String stdId,
        String room
){}
