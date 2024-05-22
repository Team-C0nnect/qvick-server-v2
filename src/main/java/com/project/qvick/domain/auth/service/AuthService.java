package com.project.qvick.domain.auth.service;

import com.project.qvick.domain.auth.client.dto.request.FirebaseRequest;
import com.project.qvick.domain.auth.client.dto.request.SignInRequest;
import com.project.qvick.domain.auth.client.dto.request.SignUpRequest;
import com.project.qvick.domain.auth.client.dto.response.JsonWebTokenResponse;
import com.project.qvick.domain.auth.client.dto.response.RefreshTokenResponse;

public interface AuthService {


    void signUp(SignUpRequest request);

    void adminSignUp(SignUpRequest request);

    JsonWebTokenResponse signIn(SignInRequest request);

    RefreshTokenResponse refresh(String token);

    void firebase(FirebaseRequest request);

}
