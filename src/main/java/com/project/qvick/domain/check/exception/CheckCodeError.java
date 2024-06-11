package com.project.qvick.domain.check.exception;

import com.project.qvick.domain.check.exception.error.CheckError;
import com.project.qvick.global.exception.BusinessException;

public class CheckCodeError extends BusinessException {

    public static final CheckCodeError EXCEPTION = new CheckCodeError();

    private CheckCodeError() {
        super(CheckError.CHECK_ERROR);
    }

}

