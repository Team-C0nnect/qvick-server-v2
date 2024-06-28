package qvick.auth.application.service;

import qvick.auth.application.response.JsonWebTokenResponse;
import qvick.auth.application.response.RefreshTokenResponse;
import qvick.auth.request.SignInRequest;
import qvick.auth.request.SignUpRequest;

public interface AuthService {


    void signUp(SignUpRequest request);

    void adminSignUp(SignUpRequest request);

    void teacherSignUp(SignUpRequest request);

    JsonWebTokenResponse signIn(SignInRequest request);

    RefreshTokenResponse refresh(String token);

}
