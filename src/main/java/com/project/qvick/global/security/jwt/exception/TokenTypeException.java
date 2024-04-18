package com.project.qvick.global.security.jwt.exception;

import com.project.qvick.global.security.jwt.exception.error.JwtTokenError;
import com.project.qvick.global.exception.BusinessException;

public class TokenTypeException extends BusinessException {

    public static final TokenTypeException EXCEPTION = new TokenTypeException();

    private TokenTypeException() {
        super(JwtTokenError.JWT_TOKEN_ERROR);
    }

}
