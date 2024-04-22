package com.project.qvick.domain.auth.service;

import com.project.qvick.domain.auth.presentation.dto.request.AdminSignUpRequest;
import com.project.qvick.domain.auth.presentation.dto.request.AuthenticationRequest;
import com.project.qvick.domain.auth.presentation.dto.request.SignInRequest;
import com.project.qvick.domain.auth.presentation.dto.request.TeacherSignUpRequest;
import com.project.qvick.domain.auth.presentation.dto.request.UserSignUpRequest;
import com.project.qvick.domain.auth.presentation.dto.response.JsonWebTokenResponse;

public interface AuthService {

    void userSignUp(UserSignUpRequest request);

    void adminSignUp(AdminSignUpRequest request);

    JsonWebTokenResponse userSignIn(SignInRequest request);

    void teacherSignUp(TeacherSignUpRequest request);

    JsonWebTokenResponse adminSignIn(SignInRequest request);

    JsonWebTokenResponse teacherSignIn(SignInRequest request);

    JsonWebTokenResponse refresh(String token);

    void firebase(AuthenticationRequest request);

}
