package com.project.qvick.global.security.jwt.exception;

import com.project.qvick.global.exception.BusinessException;
import com.project.qvick.global.security.jwt.exception.error.JwtTokenError;

public class TokenExpiredException extends BusinessException {

    public static final TokenExpiredException EXCEPTION = new TokenExpiredException();

    private TokenExpiredException() {
        super(JwtTokenError.JWT_EXPIRED);
    }

}
