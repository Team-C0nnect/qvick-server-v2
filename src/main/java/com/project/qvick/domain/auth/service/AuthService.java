package com.project.qvick.domain.auth.service;

import com.project.qvick.domain.auth.presentation.dto.request.SignInRequest;
import com.project.qvick.domain.auth.presentation.dto.request.SignUpRequest;
import com.project.qvick.domain.auth.presentation.dto.response.JsonWebTokenResponse;
import org.springframework.transaction.annotation.Transactional;

public interface AuthService {

    @Transactional
    JsonWebTokenResponse SignUp(SignUpRequest request);

    @Transactional
    void SignIn(SignInRequest request);

}
