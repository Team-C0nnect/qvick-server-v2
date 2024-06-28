package qvick.user.exception;

import qvick.exception.BusinessException;
import qvick.user.exception.error.UserError;

public class PasswordWrongException extends BusinessException {

    public static final PasswordWrongException EXCEPTION = new PasswordWrongException();

    private PasswordWrongException() {
        super(UserError.PASSWORD_WRONG);
    }

}
