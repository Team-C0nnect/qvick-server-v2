package qvick.check.exception;

import qvick.check.exception.error.CheckError;
import qvick.exception.BusinessException;

public class CheckCodeError extends BusinessException {

    public static final CheckCodeError EXCEPTION = new CheckCodeError();

    private CheckCodeError() {
        super(CheckError.CHECK_ERROR);
    }

}

