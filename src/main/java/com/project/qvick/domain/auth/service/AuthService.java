package com.project.qvick.domain.auth.service;

import com.project.qvick.domain.auth.presentation.dto.request.AuthenticationRequest;
import com.project.qvick.domain.auth.presentation.dto.request.SignInRequest;
import com.project.qvick.domain.auth.presentation.dto.request.SignUpRequest;
import com.project.qvick.domain.auth.presentation.dto.response.JsonWebTokenResponse;
import com.project.qvick.domain.auth.presentation.dto.response.RefreshTokenResponse;

public interface AuthService {


    void signUp(SignUpRequest request);

    void adminSignUp(SignUpRequest request);

    JsonWebTokenResponse signIn(SignInRequest request);

    RefreshTokenResponse refresh(String token);

    void firebase(AuthenticationRequest request);

}
