package com.project.qvick.domain.outing.exception;

import com.project.qvick.domain.outing.exception.error.OutingError;
import com.project.qvick.global.exception.BusinessException;

public class OutingBadRequestException extends BusinessException {

    public static final OutingBadRequestException EXCEPTION = new OutingBadRequestException();

    private OutingBadRequestException(){
        super(OutingError.OUTING_BAD_REQUEST);
    }

}
