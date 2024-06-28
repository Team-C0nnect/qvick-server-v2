package qvick.auth.application.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import qvick.auth.application.response.JsonWebTokenResponse;
import qvick.auth.application.response.RefreshTokenResponse;
import qvick.auth.request.SignInRequest;
import qvick.auth.request.SignUpRequest;
import qvick.security.jwt.JwtExtract;
import qvick.security.jwt.JwtProvider;
import qvick.security.jwt.enums.JwtType;
import qvick.security.jwt.exception.TokenTypeException;
import qvick.user.application.util.UserUtil;
import qvick.user.domain.enums.UserRole;
import qvick.user.domain.mapper.UserMapper;
import qvick.user.domain.repository.jpa.UserRepository;
import qvick.user.dto.User;
import qvick.user.exception.PasswordWrongException;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserUtil userUtil;
    private final PasswordEncoder encoder;
    private final JwtProvider jwtProvider;
    private final JwtExtract jwtExtract;

    @Override
    public void signUp(SignUpRequest request) {
        userUtil.userExistCheck(request.email());
        userRepository.save(userMapper.toCreate(
                request,
                encoder.encode(request.password()))
        );
    }

    @Override
    public void adminSignUp(SignUpRequest request) {
        userUtil.userExistCheck(request.email());
        userRepository.save(userMapper.toCreateAdmin(
                request,
                encoder.encode(request.password()))
        );
    }

    @Override
    public void teacherSignUp(SignUpRequest request) {
        userUtil.userExistCheck(request.email());
        userRepository.save(userMapper.toCreateTeacher(
                request,
                encoder.encode(request.password()))
        );
    }

    @Override
    public JsonWebTokenResponse signIn(SignInRequest request) {
        User user = userUtil.findUserByEmail(request.email());
        String password = user.getPassword();
        if (!encoder.matches(request.password(), password))
            throw PasswordWrongException.EXCEPTION;
        return JsonWebTokenResponse.builder()
                .accessToken(jwtProvider.generateAccessToken(request.email(),user.getUserRole()))
                .refreshToken(jwtProvider.generateRefreshToken(request.email(), user.getUserRole()))
                .userRole(user.getUserRole())
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

}
