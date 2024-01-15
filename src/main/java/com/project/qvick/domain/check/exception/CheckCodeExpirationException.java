package com.project.qvick.domain.check.exception;

import com.project.qvick.domain.check.exception.error.CheckError;
import com.project.qvick.global.exception.BusinessException;

public class CheckCodeExpirationException extends BusinessException {

    public static final CheckCodeExpirationException EXCEPTION = new CheckCodeExpirationException();
    private CheckCodeExpirationException(){
        super(CheckError.CHECK_CODE_EXPIRATION);
    }

}
