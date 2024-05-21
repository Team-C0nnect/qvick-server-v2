package com.project.qvick.domain.auth.service;

import com.project.qvick.domain.auth.client.dto.request.AuthenticationRequest;
import com.project.qvick.domain.auth.client.dto.request.SignInRequest;
import com.project.qvick.domain.auth.client.dto.request.SignUpRequest;
import com.project.qvick.domain.auth.client.dto.response.JsonWebTokenResponse;
import com.project.qvick.domain.auth.client.dto.response.RefreshTokenResponse;
import com.project.qvick.domain.user.domain.enums.UserRole;
import com.project.qvick.domain.user.domain.repository.jpa.UserRepository;
import com.project.qvick.domain.user.exception.PasswordWrongException;
import com.project.qvick.domain.user.exception.UserNotFoundException;
import com.project.qvick.domain.user.domain.mapper.UserMapper;
import com.project.qvick.domain.user.client.dto.User;
import com.project.qvick.global.common.repository.UserSecurity;
import com.project.qvick.domain.user.application.util.UserUtil;
import com.project.qvick.global.exception.BadRequestException;
import com.project.qvick.global.infra.firebase.service.FirebaseNotificationService;
import com.project.qvick.global.security.jwt.JwtExtract;
import com.project.qvick.global.security.jwt.JwtProvider;
import com.project.qvick.global.security.jwt.enums.JwtType;
import com.project.qvick.global.security.jwt.exception.TokenTypeException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserUtil userUtil;
    private final PasswordEncoder encoder;
    private final JwtProvider jwtProvider;
    private final JwtExtract jwtExtract;
    private final FirebaseNotificationService firebaseNotificationService;

    @Override
    public void signUp(SignUpRequest request) {
        userUtil.userExistCheck(request.getEmail());
        userRepository.save(userMapper.toCreate(
                request,
                encoder.encode(request.getPassword())));
    }

    @Override
    public void adminSignUp(SignUpRequest request) {
        userUtil.userExistCheck(request.getEmail());
        userRepository.save(userMapper.toCreateAdmin(
                request,
                encoder.encode(request.getPassword())));
    }

    @Override
    public JsonWebTokenResponse signIn(SignInRequest request) {
        String password = userRepository.getByEmail(request.getEmail()).getPassword();
        if (!encoder.matches(request.getPassword(), password))
            throw PasswordWrongException.EXCEPTION;
        User user = userRepository
                .findByEmail(request.getEmail())
                .map(userMapper::toUser)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
        return JsonWebTokenResponse.builder()
                .accessToken(jwtProvider.generateAccessToken(request.getEmail(),user.getUserRole()))
                .refreshToken(jwtProvider.generateRefreshToken(request.getEmail(), user.getUserRole()))
                .build();
    }

    @Override
    public RefreshTokenResponse refresh(String token) {
        Jws<Claims> claims = jwtProvider.getClaims(jwtExtract.extractToken(token));
        if (jwtExtract.isWrongType(claims, JwtType.REFRESH)) {
            throw TokenTypeException.EXCEPTION;
        }
        return RefreshTokenResponse.builder()
                .accessToken(jwtProvider.generateAccessToken(claims.getBody().getSubject(),
                        (UserRole) claims.getHeader().get("authority"))).build();
    }

    @Override
    public void firebase(AuthenticationRequest request){
        User user = userUtil.findUser();
        if(StringUtils.hasText(request.getFcmToken())){
            firebaseNotificationService.saveToken(user.getEmail(), request.getFcmToken());
        }throw BadRequestException.EXCEPTION;
    }

}
