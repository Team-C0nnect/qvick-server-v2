package qvick.check.exception;

import qvick.check.exception.error.CheckError;
import qvick.exception.BusinessException;

public class CheckCodeExpirationException extends BusinessException {

    public static final CheckCodeExpirationException EXCEPTION = new CheckCodeExpirationException();

    private CheckCodeExpirationException(){
        super(CheckError.CHECK_CODE_EXPIRATION);
    }

}
