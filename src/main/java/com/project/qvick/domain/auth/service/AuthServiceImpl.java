package com.project.qvick.domain.auth.service;

import com.project.qvick.domain.auth.presentation.dto.request.AuthenticationRequest;
import com.project.qvick.domain.auth.presentation.dto.request.SignInRequest;
import com.project.qvick.domain.auth.presentation.dto.request.SignUpRequest;
import com.project.qvick.domain.auth.presentation.dto.response.JsonWebTokenResponse;
import com.project.qvick.domain.user.domain.enums.UserRole;
import com.project.qvick.domain.user.domain.repository.UserRepository;
import com.project.qvick.domain.user.exception.PasswordWrongException;
import com.project.qvick.domain.user.exception.UserExistException;
import com.project.qvick.domain.user.exception.UserNotFoundException;
import com.project.qvick.domain.user.mapper.UserMapper;
import com.project.qvick.domain.user.presentation.dto.User;
import com.project.qvick.global.common.jwt.JwtProvider;
import com.project.qvick.global.common.repository.UserSecurity;
import com.project.qvick.global.infra.firebase.service.FirebaseNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    @Override
    public void SignUp(SignUpRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent())
            throw UserExistException.EXCEPTION;
        userRepository.save(userMapper.toCreate(
                request,
                encoder.encode(request.getPassword())));
    }

    @Transactional
    @Override
    public JsonWebTokenResponse SignIn(SignInRequest request) {
        String userPassword = userRepository.getByEmail(request.getEmail()).getPassword();
        if (!encoder.matches(request.getPassword(), userPassword))
            throw PasswordWrongException.EXCEPTION;
        return JsonWebTokenResponse.builder()
                .accessToken(jwtProvider.generateAccessToken(request.getEmail(),UserRole.USER))
                .refreshToken(jwtProvider.generateRefreshToken(request.getEmail(), UserRole.USER))
                .build();

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
