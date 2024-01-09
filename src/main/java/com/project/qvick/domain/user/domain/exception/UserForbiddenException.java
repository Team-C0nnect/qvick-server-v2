package com.project.qvick.domain.user.domain.exception;

import com.project.qvick.domain.user.domain.exception.error.UserError;
import com.project.qvick.global.exception.BusinessException;

public class UserForbiddenException extends BusinessException {
    public static final UserForbiddenException EXCEPTION = new UserForbiddenException();
    private UserForbiddenException(){
        super(UserError.USER_FORBIDDEN);
    }
}
