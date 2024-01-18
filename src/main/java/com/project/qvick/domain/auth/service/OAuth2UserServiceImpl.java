package com.project.qvick.domain.auth.service;


import com.project.qvick.domain.auth.presentation.dto.request.AuthenticationRequest;
import com.project.qvick.domain.auth.presentation.dto.response.JsonWebTokenResponse;
import com.project.qvick.domain.user.domain.UserEntity;
import com.project.qvick.domain.user.domain.enums.UserRole;
import com.project.qvick.domain.user.domain.repository.UserRepository;
import com.project.qvick.domain.user.exception.UserNotFoundException;
import com.project.qvick.domain.user.mapper.UserMapper;
import com.project.qvick.domain.user.presentation.dto.User;
import com.project.qvick.global.common.jwt.JwtProvider;
import com.project.qvick.global.common.jwt.enums.JwtType;
import com.project.qvick.global.common.jwt.exception.TokenTypeException;
import com.project.qvick.global.infra.google.dto.OAuth2Attribute;
import com.project.qvick.global.infra.google.service.GoogleService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.lang.Strings;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
/**OAtuh2 로그인 기능 구현 클래스*/
public class OAuth2UserServiceImpl implements OAuth2UserService {

    //의존성 주입
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final GoogleService googleService;
//    private final FirebaseNotificationService firebaseNotificationService;
    private final JwtProvider jwtProvider;

    /**JWT 생성*/
    public JsonWebTokenResponse auth(AuthenticationRequest request) {
        OAuth2Attribute oAuth2Attribute = googleService.getTokenInfo(request.getIdToken());
        if (!Strings.hasText(oAuth2Attribute.getEmail())) {
            throw UserNotFoundException.EXCEPTION;
        }
        User user = findOrSave(oAuth2Attribute);
//        if(StringUtils.hasText(request.getFcmToken()))
//            firebaseNotificationService.saveToken(user.getEmail(), request.getFcmToken());
        return JsonWebTokenResponse.builder()
                .accessToken(jwtProvider.generateAccessToken(user.getEmail(), user.getUserRole()))
                .refreshToken(jwtProvider.generateRefreshToken(user.getEmail(), user.getUserRole()))
                .build();
    }

    /**refresh 토큰 생성*/
    @Override
    public JsonWebTokenResponse refresh(String token) {
        Jws<Claims> claims = jwtProvider.getClaims(jwtProvider.extractToken(token));
        if (jwtProvider.isWrongType(claims, JwtType.REFRESH)) {
            throw TokenTypeException.EXCEPTION;
        }
        return JsonWebTokenResponse.builder()
                .accessToken(jwtProvider.generateAccessToken(claims.getBody().getSubject(), (UserRole) claims.getHeader().get("authority")))
                .build();
    }

    /**신규회원 확인 후 저장*/
    private User findOrSave(OAuth2Attribute oAuth2Attribute) {
        User user = userRepository.findByEmail(oAuth2Attribute.getEmail()).map(userMapper::toUser).orElse(null);
        if (user == null) {
            return save(userMapper.createEntity(oAuth2Attribute));
        }
        return user;
    }

    /**유저 저장*/
    private User save(final UserEntity userEntity) {
        return userMapper.toUser(userRepository.save(userEntity));
    }

}
