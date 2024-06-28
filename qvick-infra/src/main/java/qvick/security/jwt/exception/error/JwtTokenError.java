package qvick.security.jwt.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import qvick.exception.error.ErrorProperty;


@Getter
@RequiredArgsConstructor
public enum JwtTokenError implements ErrorProperty {

    JWT_TOKEN_ERROR(HttpStatus.BAD_REQUEST, "잘못된 타입"),
    JWT_EXPIRED(HttpStatus.GONE,"만료된 토큰"),
    JWT_ERROR(HttpStatus.BAD_REQUEST,"잘못된 토큰"),
    JWT_NOT_SUPPORT(HttpStatus.BAD_REQUEST,"지원하지 않는 토큰");

    private final HttpStatus status;
    private final String message;

}