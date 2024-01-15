package com.project.qvick.domain.student.exception;

import com.project.qvick.domain.student.exception.error.StudentError;
import com.project.qvick.global.exception.BusinessException;

/**학생을 찾을 수 없음 예외처리*/
public class StudentNotFoundException extends BusinessException {

    public static final StudentNotFoundException EXCEPTION = new StudentNotFoundException();

    private StudentNotFoundException(){
        super(StudentError.STUDENT_NOT_FOUND);
    }

}
