package qvick.security.jwt.exception;

import qvick.exception.BusinessException;
import qvick.security.jwt.exception.error.JwtTokenError;

public class TokenExpiredException extends BusinessException {

    public static final TokenExpiredException EXCEPTION = new TokenExpiredException();

    private TokenExpiredException() {
        super(JwtTokenError.JWT_EXPIRED);
    }

}
