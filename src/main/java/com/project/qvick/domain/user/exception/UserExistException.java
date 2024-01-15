package com.project.qvick.domain.user.exception;

import com.project.qvick.domain.user.exception.error.UserError;
import com.project.qvick.global.exception.BusinessException;

public class UserExistException extends BusinessException {

    public static final UserExistException EXCEPTION = new UserExistException();

    private UserExistException(){
        super(UserError.USER_EXIST);
    }

}
