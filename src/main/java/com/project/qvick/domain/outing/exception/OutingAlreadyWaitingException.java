package com.project.qvick.domain.outing.exception;

import com.project.qvick.domain.outing.exception.error.OutingError;
import com.project.qvick.global.exception.BusinessException;

public class OutingAlreadyWaitingException extends BusinessException {

    public static final OutingAlreadyWaitingException EXCEPTION = new OutingAlreadyWaitingException();

    private OutingAlreadyWaitingException(){
        super(OutingError.OUTING_CONFLICT);
    }

}
