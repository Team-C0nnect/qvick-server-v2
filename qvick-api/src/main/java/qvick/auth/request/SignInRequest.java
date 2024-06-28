package qvick.auth.request;

public record SignInRequest(
        String email,
        String password
){}
