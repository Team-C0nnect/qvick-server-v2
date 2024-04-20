package com.project.qvick.domain.auth.service;

import com.project.qvick.domain.auth.presentation.dto.request.AuthenticationRequest;
import com.project.qvick.domain.auth.presentation.dto.request.SignInRequest;
import com.project.qvick.domain.auth.presentation.dto.request.SignUpRequest;
import com.project.qvick.domain.auth.presentation.dto.response.JsonWebTokenResponse;
import org.springframework.transaction.annotation.Transactional;

public interface AuthService {

    void SignUp(SignUpRequest request);

    JsonWebTokenResponse SignIn(SignInRequest request);

    JsonWebTokenResponse refresh(String token);

    void firebase(AuthenticationRequest request);
}
