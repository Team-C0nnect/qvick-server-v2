package com.project.qvick.domain.auth.presentation;

import com.project.qvick.domain.auth.dto.request.AuthenticationRequest;
import com.project.qvick.domain.auth.dto.request.RefreshTokenRequest;
import com.project.qvick.domain.auth.dto.response.JsonWebTokenResponse;
import com.project.qvick.domain.auth.service.OAuth2UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "인증", description = "인증")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final OAuth2UserService oAuth2UserService;

    @Operation(summary = "회원 인증", description = "회원 인증")
    @PostMapping("")
    public JsonWebTokenResponse auth(@Validated @RequestBody AuthenticationRequest authRequest) {
        return oAuth2UserService.auth(authRequest);
    }

    @Operation(summary = "토큰 재발급", description = "토큰 재발급")
    @PostMapping("/refresh")
    public JsonWebTokenResponse refresh(@Validated @RequestBody RefreshTokenRequest refreshTokenRequest) {
        return oAuth2UserService.refresh(refreshTokenRequest.getRefreshToken());
    }

}
