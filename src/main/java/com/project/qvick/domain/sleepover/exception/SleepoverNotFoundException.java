package com.project.qvick.domain.sleepover.exception;

import com.project.qvick.domain.sleepover.exception.error.SleepoverError;
import com.project.qvick.global.exception.BusinessException;

public class SleepoverNotFoundException extends BusinessException {

    public static final SleepoverNotFoundException EXCEPTION = new SleepoverNotFoundException();

    private SleepoverNotFoundException(){
        super(SleepoverError.SLEEPOVER_NOT_FOUND);
    }

}
