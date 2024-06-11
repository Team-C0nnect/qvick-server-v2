package com.project.qvick.domain.check.exception;

import com.project.qvick.domain.check.exception.error.CheckError;
import com.project.qvick.global.exception.BusinessException;

public class CheckAlreadyExistsException extends BusinessException {

    public static final CheckAlreadyExistsException EXCEPTION = new CheckAlreadyExistsException();

    private CheckAlreadyExistsException() {
        super(CheckError.CHECK_CONFLICT);
    }
}