package com.project.qvick.domain.school.exception;

import com.project.qvick.domain.school.exception.error.SchoolError;
import com.project.qvick.global.exception.BusinessException;

public class SchoolExistException extends BusinessException {

    private final SchoolExistException EXCEPTION = new SchoolExistException();

    private SchoolExistException(){
        super(SchoolError.SCHOOL_EXIST);
    }

}
