package qvick.check.exception;

import qvick.check.exception.error.CheckError;
import qvick.exception.BusinessException;

public class CheckAlreadyExistsException extends BusinessException {

    public static final CheckAlreadyExistsException EXCEPTION = new CheckAlreadyExistsException();

    private CheckAlreadyExistsException() {
        super(CheckError.CHECK_CONFLICT);
    }
}