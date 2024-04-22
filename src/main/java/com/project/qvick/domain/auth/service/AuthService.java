package com.project.qvick.domain.auth.service;

import com.project.qvick.domain.auth.presentation.dto.request.AuthenticationRequest;
import com.project.qvick.domain.auth.presentation.dto.request.SignInRequest;
import com.project.qvick.domain.auth.presentation.dto.request.SignUpRequest;
import com.project.qvick.domain.auth.presentation.dto.response.JsonWebTokenResponse;

public interface AuthService {

    void signUp(SignUpRequest request);

    JsonWebTokenResponse signIn(SignInRequest request);

    JsonWebTokenResponse adminSignIn(SignInRequest request);

    JsonWebTokenResponse refresh(String token);

    void firebase(AuthenticationRequest request);

}
