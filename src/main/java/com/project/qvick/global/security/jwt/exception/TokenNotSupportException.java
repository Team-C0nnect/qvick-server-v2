package com.project.qvick.global.security.jwt.exception;

import com.project.qvick.global.exception.BusinessException;
import com.project.qvick.global.security.jwt.exception.error.JwtTokenError;

public class TokenNotSupportException extends BusinessException {

    public static final TokenNotSupportException EXCEPTION = new TokenNotSupportException();

    private TokenNotSupportException() {
        super(JwtTokenError.JWT_NOT_SUPPORT);
    }


}
