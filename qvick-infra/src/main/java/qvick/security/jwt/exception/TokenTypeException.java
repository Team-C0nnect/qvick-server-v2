package qvick.security.jwt.exception;

import qvick.exception.BusinessException;
import qvick.security.jwt.exception.error.JwtTokenError;

public class TokenTypeException extends BusinessException {

    public static final TokenTypeException EXCEPTION = new TokenTypeException();

    private TokenTypeException() {
        super(JwtTokenError.JWT_TOKEN_ERROR);
    }

}
