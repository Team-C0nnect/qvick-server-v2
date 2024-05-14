package com.project.qvick.domain.auth.service;

import com.project.qvick.domain.auth.presentation.dto.request.AuthenticationRequest;
import com.project.qvick.domain.auth.presentation.dto.request.SignInRequest;
import com.project.qvick.domain.auth.presentation.dto.request.SignUpRequest;
import com.project.qvick.domain.auth.presentation.dto.response.JsonWebTokenResponse;
import com.project.qvick.domain.auth.presentation.dto.response.RefreshTokenResponse;
import com.project.qvick.domain.user.domain.enums.UserRole;
import com.project.qvick.domain.user.domain.repository.UserRepository;
import com.project.qvick.domain.user.exception.PasswordWrongException;
import com.project.qvick.domain.user.exception.UserExistException;
import com.project.qvick.domain.user.exception.UserNotFoundException;
import com.project.qvick.domain.user.mapper.UserMapper;
import com.project.qvick.domain.user.presentation.dto.User;
import com.project.qvick.global.common.repository.UserSecurity;
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
    private final PasswordEncoder encoder;
    private final JwtProvider jwtProvider;
    private final FirebaseNotificationService firebaseNotificationService;
    private final UserSecurity userSecurity;
    private final JwtExtract jwtExtract;

    @Override
    public void signUp(SignUpRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent())
            throw UserExistException.EXCEPTION;
        userRepository.save(userMapper.toCreate(
                request,
                encoder.encode(request.getPassword())));
    }

    @Override
    public void adminSignUp(SignUpRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent())
            throw UserExistException.EXCEPTION;
        userRepository.save(userMapper.toCreateAdmin(
                request,
                encoder.encode(request.getPassword())));
    }

    @Override
    public JsonWebTokenResponse signIn(SignInRequest request) {
        if(userRepository.findByEmail(request.getEmail()).isEmpty())
            throw UserNotFoundException.EXCEPTION;
        String password = userRepository.getByEmail(request.getEmail()).getPassword();
        if (!encoder.matches(request.getPassword(), password))
            throw PasswordWrongException.EXCEPTION;
        User user = userRepository
                .findByEmail(request.getEmail())
                .map(userMapper::toUser)
                .orElseThrow(()->UserNotFoundException.EXCEPTION);
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
        User user = userRepository.findById(userSecurity.getUser().getId())
                .map(userMapper::toUser)
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);
        if(StringUtils.hasText(request.getFcmToken())){
            firebaseNotificationService.saveToken(user.getEmail(), request.getFcmToken());
        }
    }

}
