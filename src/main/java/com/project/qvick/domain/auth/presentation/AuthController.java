package com.project.qvick.domain.auth.presentation;

import com.project.qvick.domain.auth.presentation.dto.request.AuthenticationRequest;
import com.project.qvick.domain.auth.presentation.dto.request.SignInRequest;
import com.project.qvick.domain.auth.presentation.dto.request.SignUpRequest;
import com.project.qvick.domain.auth.presentation.dto.response.JsonWebTokenResponse;
import com.project.qvick.domain.auth.service.AuthService;
import com.project.qvick.domain.user.presentation.dto.User;
import com.project.qvick.global.infra.firebase.service.FirebaseNotificationService;
import com.project.qvick.global.infra.firebase.service.FirebaseNotificationServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
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

    @Operation(summary = "회원가입", description = "회원가입")
    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@Validated @RequestBody SignUpRequest signUpRequest){
        authService.SignUp(signUpRequest);
    }

    @Operation(summary = "로그인", description = "로그인")
    @PostMapping("/sign-in")
    public JsonWebTokenResponse signIn(@Validated @RequestBody SignInRequest signInRequest){
        return authService.SignIn(signInRequest);
    }

    @Operation(summary = "firebase 인증", description = "firebase 인증 서비스")
    @PostMapping("/firebase")
    public void firebase(AuthenticationRequest request){
        authService.firebase(request);
    }

}
