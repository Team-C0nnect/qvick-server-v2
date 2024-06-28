package qvick.security.jwt.exception;

import qvick.exception.BusinessException;
import qvick.security.jwt.exception.error.JwtTokenError;

public class TokenErrorException extends BusinessException {

    public static final TokenErrorException EXCEPTION = new TokenErrorException();

    private TokenErrorException() {
        super(JwtTokenError.JWT_TOKEN_ERROR);
    }


}
