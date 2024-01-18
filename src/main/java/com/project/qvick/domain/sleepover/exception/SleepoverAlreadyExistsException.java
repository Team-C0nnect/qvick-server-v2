package com.project.qvick.domain.sleepover.exception;

import com.project.qvick.domain.sleepover.exception.error.SleepoverError;
import com.project.qvick.global.exception.BusinessException;

public class SleepoverAlreadyExistsException extends BusinessException {

    public static final SleepoverAlreadyExistsException EXCEPTION = new SleepoverAlreadyExistsException();

    private SleepoverAlreadyExistsException(){
        super(SleepoverError.SLEEPOVER_CONFLICT);
    }

}
