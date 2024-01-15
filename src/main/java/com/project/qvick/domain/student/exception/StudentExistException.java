package com.project.qvick.domain.student.exception;

import com.project.qvick.domain.student.exception.error.StudentError;
import com.project.qvick.global.exception.BusinessException;

/**학생이 이미 존재함 예외처리*/
public class StudentExistException extends BusinessException {

    public static final StudentExistException EXCEPTION = new StudentExistException();

    private StudentExistException(){
        super(StudentError.STUDENT_NOT_FOUND);
    }

}
