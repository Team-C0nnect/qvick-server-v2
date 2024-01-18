package com.project.qvick.domain.school.exception;

import com.project.qvick.domain.school.exception.error.SchoolError;
import com.project.qvick.global.exception.BusinessException;

public class SchoolNotFoundException extends BusinessException {

    public static final SchoolNotFoundException EXCEPTION = new SchoolNotFoundException();

    private SchoolNotFoundException(){
        super(SchoolError.SCHOOL_NOT_FOUND);
    }

}

