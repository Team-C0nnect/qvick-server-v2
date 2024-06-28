package qvick.security.jwt.exception;

import qvick.exception.BusinessException;
import qvick.security.jwt.exception.error.JwtTokenError;

public class TokenNotSupportException extends BusinessException {

    public static final TokenNotSupportException EXCEPTION = new TokenNotSupportException();

    private TokenNotSupportException() {
        super(JwtTokenError.JWT_NOT_SUPPORT);
    }


}
