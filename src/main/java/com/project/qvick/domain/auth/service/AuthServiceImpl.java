package com.project.qvick.domain.auth.service;

import com.project.qvick.domain.auth.presentation.dto.request.AdminSignUpRequest;
import com.project.qvick.domain.auth.presentation.dto.request.AuthenticationRequest;
import com.project.qvick.domain.auth.presentation.dto.request.SignInRequest;
import com.project.qvick.domain.auth.presentation.dto.request.SignUpRequest;
import com.project.qvick.domain.auth.presentation.dto.response.JsonWebTokenResponse;
import com.project.qvick.domain.user.domain.enums.UserRole;
import com.project.qvick.domain.user.domain.repository.AdminRepository;
import com.project.qvick.domain.user.domain.repository.UserRepository;
import com.project.qvick.domain.user.exception.PasswordWrongException;
import com.project.qvick.domain.user.exception.UserExistException;
import com.project.qvick.domain.user.exception.UserNotFoundException;
import com.project.qvick.domain.user.mapper.AdminMapper;
import com.project.qvick.domain.user.mapper.UserMapper;
import com.project.qvick.domain.user.presentation.dto.User;
import com.project.qvick.global.common.repository.UserSecurity;
import com.project.qvick.global.infra.firebase.service.FirebaseNotificationService;
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
    private final AdminRepository adminRepository;
    private final UserMapper userMapper;
    private final AdminMapper adminMapper;
    private final PasswordEncoder encoder;
    private final JwtProvider jwtProvider;
    private final FirebaseNotificationService firebaseNotificationService;
    private final UserSecurity userSecurity;

    @Override
    public void signUp(SignUpRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent())
            throw UserExistException.EXCEPTION;
        userRepository.save(userMapper.toCreate(
                request,
                encoder.encode(request.getPassword())));
    }

    @Override
    public void adminSignUp(AdminSignUpRequest request) {
        if(adminRepository.findByEmail(request.getEmail()).isPresent()){
            throw UserExistException.EXCEPTION;
        }
        adminRepository.save(adminMapper.toEntity(request, encoder.encode(request.getPassword())));
    }

    @Override
    public JsonWebTokenResponse adminSignIn(SignInRequest request) {
        String adminPassword = adminRepository.getByEmail(request.getEmail()).getPassword();
        if (!encoder.matches(request.getPassword(), adminPassword))
            throw PasswordWrongException.EXCEPTION;
        return JsonWebTokenResponse.builder()
                .accessToken(jwtProvider.generateAccessToken(request.getEmail(),UserRole.ADMIN))
                .refreshToken(jwtProvider.generateRefreshToken(request.getEmail(), UserRole.ADMIN))
                .build();
    }

    @Override
    public JsonWebTokenResponse signIn(SignInRequest request) {
        String userPassword = userRepository.getByEmail(request.getEmail()).getPassword();
        if (!encoder.matches(request.getPassword(), userPassword))
            throw PasswordWrongException.EXCEPTION;
        return JsonWebTokenResponse.builder()
                .accessToken(jwtProvider.generateAccessToken(request.getEmail(),UserRole.USER))
                .refreshToken(jwtProvider.generateRefreshToken(request.getEmail(), UserRole.USER))
                .build();
    }

    @Override
    public JsonWebTokenResponse refresh(String token) {
        Jws<Claims> claims = jwtProvider.getClaims(jwtProvider.extractToken(token));
        if (jwtProvider.isWrongType(claims, JwtType.REFRESH)) {
            throw TokenTypeException.EXCEPTION;
        }
        return JsonWebTokenResponse.builder()
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
