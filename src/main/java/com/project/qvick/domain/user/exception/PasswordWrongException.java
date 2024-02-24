package com.project.qvick.domain.user.exception;

import com.project.qvick.domain.user.exception.error.UserError;
import com.project.qvick.global.exception.BusinessException;

public class PasswordWrongException extends BusinessException {

    public static final PasswordWrongException EXCEPTION = new PasswordWrongException();

    private PasswordWrongException() {
        super(UserError.PASSWORD_WRONG);
    }
}
