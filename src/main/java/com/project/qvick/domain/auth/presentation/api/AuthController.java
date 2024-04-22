package com.project.qvick.domain.auth.presentation.api;

import com.project.qvick.domain.auth.presentation.dto.request.AdminSignUpRequest;
import com.project.qvick.domain.auth.presentation.dto.request.AuthenticationRequest;
import com.project.qvick.domain.auth.presentation.dto.request.RefreshTokenRequest;
import com.project.qvick.domain.auth.presentation.dto.request.SignInRequest;
import com.project.qvick.domain.auth.presentation.dto.request.SignUpRequest;
import com.project.qvick.domain.auth.presentation.dto.request.TeacherSignUpRequest;
import com.project.qvick.domain.auth.presentation.dto.request.UserSignUpRequest;
import com.project.qvick.domain.auth.presentation.dto.response.JsonWebTokenResponse;
import com.project.qvick.domain.auth.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "인증", description = "인증")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "유저 회원가입", description = "유저 회원가입")
    @PostMapping("/sign-up/user")
    @ResponseStatus(HttpStatus.CREATED)
    public void userSignUp(@Validated @RequestBody UserSignUpRequest signUpRequest){
        authService.userSignUp(signUpRequest);
    }

    @Operation(summary = "선생님 회원가입", description = "선생님 회원가입")
    @PostMapping("/sign-up/teacher")
    @ResponseStatus(HttpStatus.CREATED)
    public void teacherSignUp(@Validated @RequestBody TeacherSignUpRequest signUpRequest){
        authService.teacherSignUp(signUpRequest);
    }

    @Operation(summary = "관리자 회원가입", description = "관리자 회원가입")
    @PostMapping("/sign-up/admin")
    @ResponseStatus(HttpStatus.CREATED)
    public void adminSignUp(@Validated @RequestBody AdminSignUpRequest signUpRequest){
        authService.adminSignUp(signUpRequest);
    }

    @Operation(summary = "로그인", description = "로그인")
    @PostMapping("/sign-in/user")
    public JsonWebTokenResponse signIn(@Validated @RequestBody SignInRequest signInRequest){
        return authService.userSignIn(signInRequest);
    }

    @Operation(summary = "관리자 로그인", description = "관리자 로그인")
    @PostMapping("/sign-in/admin")
    public JsonWebTokenResponse adminSignIn(@Validated @RequestBody SignInRequest signInRequest){
        return authService.adminSignIn(signInRequest);
    }

    @Operation(summary = "선생님 로그인", description = "선생님 로그인")
    @PostMapping("/sign-in/teacher")
    public JsonWebTokenResponse teacherSignIn(@Validated @RequestBody SignInRequest signInRequest){
        return authService.teacherSignIn(signInRequest);
    }

    @Operation(summary = "토큰 재발급", description = "acess 토큰을 재발급 합니다")
    @PostMapping("/refresh")
    public JsonWebTokenResponse refresh(RefreshTokenRequest request){
        return authService.refresh(request.getRefreshToken());
    }

    @Operation(summary = "firebase 인증", description = "firebase 인증 서비스")
    @PostMapping("/firebase")
    public void firebase(AuthenticationRequest request){
        authService.firebase(request);
    }

}
