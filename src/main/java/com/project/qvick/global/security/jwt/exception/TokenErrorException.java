package com.project.qvick.global.security.jwt.exception;

import com.project.qvick.global.exception.BusinessException;
import com.project.qvick.global.security.jwt.exception.error.JwtTokenError;

public class TokenErrorException extends BusinessException {

    public static final TokenErrorException EXCEPTION = new TokenErrorException();

    private TokenErrorException() {
        super(JwtTokenError.JWT_TOKEN_ERROR);
    }


}
