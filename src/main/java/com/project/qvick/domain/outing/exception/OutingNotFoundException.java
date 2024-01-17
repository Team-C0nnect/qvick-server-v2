package com.project.qvick.domain.outing.exception;

import com.project.qvick.domain.outing.exception.error.OutingError;
import com.project.qvick.global.exception.BusinessException;

public class OutingNotFoundException extends BusinessException {

    public static final OutingNotFoundException EXCEPTION = new OutingNotFoundException();

    private OutingNotFoundException(){
        super(OutingError.OUTING_NOT_FOUND);
    }

}
